import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class CopyTable {

    public static void main(String[] args) {
        new CopyTable();
    }

    public CopyTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DefaultTableModel model = new DefaultTableModel();
                for (int index = 0; index < 26; index++) {
                    model.addColumn((char) (index + 65));
                }

                for (int row = 0; row < 26; row++) {
                    Vector rowData = new Vector();
                    for (int col = 0; col < 26; col++) {
                        rowData.add(row + "x" + col);
                    }
                    model.addRow(rowData);
                }

                JTable table = new JTable(model);
                table.getActionMap().put("copy", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = table.getSelectedRow();
                        StringBuilder sb = new StringBuilder(128);
                        sb.append("<table border=1 width=100%><tr>");
                        for (int col = 0; col < table.getColumnCount(); col++) {
                            sb.append("<td>");
                            sb.append(table.getValueAt(row, col).toString());
                            sb.append("</td>");
                        }
                        sb.append("</tr></table>");

                        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clipboard.setContents(new HtmlSelection(sb.toString()), null);
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private static class HtmlSelection implements Transferable {

        private static ArrayList htmlFlavors = new ArrayList();

        static {

            try {

                htmlFlavors.add(new DataFlavor("text/html;class=java.lang.String"));

                htmlFlavors.add(new DataFlavor("text/html;class=java.io.Reader"));

                htmlFlavors.add(new DataFlavor("text/html;charset=unicode;class=java.io.InputStream"));

            } catch (ClassNotFoundException ex) {

                ex.printStackTrace();

            }

        }

        private String html;

        public HtmlSelection(String html) {

            this.html = html;

        }

        public DataFlavor[] getTransferDataFlavors() {

            return (DataFlavor[]) htmlFlavors.toArray(new DataFlavor[htmlFlavors.size()]);

        }

        public boolean isDataFlavorSupported(DataFlavor flavor) {

            return htmlFlavors.contains(flavor);

        }

        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {

            if (String.class.equals(flavor.getRepresentationClass())) {

                return html;

            } else if (Reader.class.equals(flavor.getRepresentationClass())) {

                return new StringReader(html);

            } else if (InputStream.class.equals(flavor.getRepresentationClass())) {

                return new StringBufferInputStream(html);

            }

            throw new UnsupportedFlavorException(flavor);

        }

    }
}