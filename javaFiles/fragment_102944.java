import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;

public class MongoStackoverflow {
    private static JTable table;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                table = new JTable(){
                    @Override
                    public Dimension getPreferredScrollableViewportSize() {
                        return new Dimension(300, 150);
                    }
                };
                JPanel panel = new JPanel(new BorderLayout());
                JButton button = new JButton("Show Data");
                button.addActionListener(listener);
                panel.add(new JScrollPane(table));
                panel.add(button, BorderLayout.PAGE_END);
                JOptionPane.showMessageDialog(null, panel);
            }
        };
        SwingUtilities.invokeLater(runnable);
    }

    static ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            MongoClient mongoClient = null;
            DBCursor cursor = null;
            try {
                mongoClient = new MongoClient( "localhost" , 27017 );
                DB db = mongoClient.getDB( "swingtest" );
                DBCollection coll = db.getCollection("table");
                cursor = coll.find();

                String[] columnNames = {"id", "First", "Last"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);

                while(cursor.hasNext()) {
                    DBObject obj = cursor.next();
                    String first = (String)obj.get("first");
                    String last = (String)obj.get("last");
                    ObjectId id = (ObjectId)obj.get("_id");
                    model.addRow(new Object[] { id, first, last });
                }
                table.setModel(model);

                cursor.close(); 
                mongoClient.close();
            } catch (UnknownHostException ex) {
                Logger.getLogger(MongoStackoverflow.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (cursor!= null) {
                    cursor.close();
                }
                if (mongoClient != null) {
                     mongoClient.close();
                }   
            }
        }
    }; 
}