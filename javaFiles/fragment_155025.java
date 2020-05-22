import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class TableToolTip {

    private Map<String, URL> fileMap;

    public TableToolTip() {
        fileMap = new HashMap<>();
        JTable table = createTable();

        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JTable createTable() {
        JTable table = new JTable(createModel()) {

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (c instanceof JComponent) {
                    JComponent jc = (JComponent) c;
                    URL url = fileMap.get((String) getValueAt(row, column));
                    String html = "<html><body>"
                            + "<img src='"
                            + url
                            + "' width=150 height=150> ";

                    jc.setToolTipText(html + "<br/>"
                            + getValueAt(row, column).toString()
                            + ":  row, col (" + row + ", " + column + ")"
                            + "</body></html>");
                }
                return c;
            }
        };
        return table;
    }

    private DefaultTableModel createModel() {
        DefaultTableModel model = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/mario", "root", "password");
            PreparedStatement ps = conn.prepareStatement("select * from characters");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            String colTitle = rsMeta.getColumnName(1);

            model = new DefaultTableModel(new String[]{colTitle}, 0);

            while (rs.next()) {
                String name = rs.getString("NAME");
                model.addRow(new Object[]{name});
                File temp = File.createTempFile(name, ".png");
                Blob blob = rs.getBlob("IMG");
                int blobLength = (int) blob.length();
                byte[] bytes = blob.getBytes(1, blobLength);
                blob.free();
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
                ImageIO.write(img, "png", temp);

                URL fileURL = temp.toURI().toURL();
                fileMap.put(name, fileURL);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableToolTip();
            }
        });
    }
}