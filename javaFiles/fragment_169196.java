import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

@SuppressWarnings("unchecked")
public class FillTable extends JFrame
{
    private Vector columnNames, data, row;
    private Connection connection;
    private final String dbUsername = "aUsername";
    private final String dbPassword = "aPass";

    private JTable groceryTable;
    private TableColumn column;
    private JScrollPane pane;
    private JPanel panel;

    public FillTable()
    {
        createComponents();
        setSize(800,800);
        setTitle("A filled Table");
    }

    public static void main(String[] args)
    {
        JFrame frame = new FillTable();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

class ButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            connection = DriverManager.getConnection("redactedDBINFO", dbUsername, dbPassword);
            String sql = "select upper(name) as Grocery, fname as ordered_by, dateordered as date_ordered from groceries inner join grocerylist on groceries.groceryid=grocerylist.groceryid inner join users on grocerylist.orderedby= users.userid";  
            Statement statement = connection.prepareStatement(sql);
            ResultSet rset = statement.executeQuery(sql);            
            groceryTable.setModel(updateModel(rset));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

public DefaultTableModel updateModel(ResultSet rset) throws SQLException
{

    ResultSetMetaData metaData = rset.getMetaData();

    Vector<String> columnNames = new Vector<String>();

    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rset.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rset.getObject(columnIndex));
        }
        data.add(vector);
    }
    return new DefaultTableModel(data, columnNames);
}

private void createComponents()
{
    JButton button = new JButton("Press me");
    ActionListener buttonListener = new ButtonListener();
    button.addActionListener(buttonListener);

    groceryTable = new JTable();

    pane = new JScrollPane(groceryTable);

    panel = new JPanel();
    panel.add(button);
    panel.add(pane);
    add(panel);
}   
}