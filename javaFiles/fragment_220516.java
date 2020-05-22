import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Category {
    private final String name;
    private final int id;
    private final Category parent;
    private final ArrayList<Category> children = new ArrayList<>();

    private Category(final String name, final int id, final Category parent) {
        this.name   = name;
        this.id     = id;
        this.parent = parent;
        if ( parent != null )
            parent.children.add(this);
    }

    @Override
    public String toString(){
        final StringBuffer buffer = new StringBuffer();
        buffer.append( '<' );
        buffer.append(name);
        buffer.append(':');
        buffer.append(id);
        buffer.append(':');
        buffer.append(parent == null ? "" : parent.name );
        buffer.append( '>' );
        return buffer.toString();
    }

    public String toHierarchyString(){
        return toHierarchyString(0);
    }

    private String toHierarchyString( int level ){
        final StringBuffer buffer = new StringBuffer();
        for ( int i = 0; i < level; i++ )
            buffer.append('\t');
        buffer.append( toString() );
        buffer.append( '\n' );
        for ( final Category child : children )
            buffer.append( child.toHierarchyString(level+1));
        return buffer.toString();
    }
    public static ArrayList<Category> loadCategoriesFromDatabase(){
        try{

            Class.forName("oracle.jdbc.OracleDriver");

            final Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","TEST","TEST");
            final PreparedStatement st = con.prepareStatement(
                    "SELECT id, name, parent_id " +
                    "FROM  categories " +
                    "START WITH parent_id IS NULL " +
                    "CONNECT BY PRIOR id = PARENT_ID " +
                    "ORDER SIBLINGS BY name"
            );

            final ResultSet cursor = st.executeQuery();

            final HashMap<Integer,Category> categoryMap = new HashMap<>();
            final ArrayList<Category> categories = new ArrayList<>();

            while ( cursor.next() )
            {
                final String name       = cursor.getString("NAME");
                final int id            = cursor.getInt("ID");
                final Integer parent_id = cursor.getInt("PARENT_ID");
                final Category parent   = categoryMap.get( parent_id );
                final Category category = new Category( name, id, parent );
                categoryMap.put(id, category);
                if ( parent == null )
                    categories.add(category);
            }
            return categories;
        } catch(ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void main( final String[] args ){
        ArrayList<Category> categories = loadCategoriesFromDatabase();
        for ( final Category cat : categories )
            System.out.println( cat.toHierarchyString() );
    }
}