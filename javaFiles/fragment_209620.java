import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CopyTableModel {

    public static void main(String[] args) {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
            {"A1", "A2", "A3", "A4", "A5"},
            {"B1", "B2", "B3", "B4", "B5"},
            {"C1", "C2", "C3", "C4", "C5"},
            {"D1", "D2", "D3", "D4", "D5"},
            {"E1", "E2", "E3", "E4", "E5"},
            {"F1", "F2", "F3", "F4", "F5"}
        },
                new Object[]{"1", "2", "3", "4", "5"});

        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        cb.setContents(new TableTransferable(model), new ClipboardOwner() {
            @Override
            public void lostOwnership(Clipboard clipboard, Transferable contents) {
                System.out.println("You lose :(");
            }
        });

    }

    public static class TableTransferable implements Transferable {

        public static final DataFlavor TABLE_DATA_FLAVOR = new DataFlavor(TableModel.class, "binary/x-java-tablemodel; class=<javax.swing.TableModel>");
        public static final DataFlavor HTML_DATA_FLAVOR = new DataFlavor("text/html", "HTML");
        public static final DataFlavor CSV_DATA_FLAVOR = new DataFlavor("text/csv", "CVS");
        public static final DataFlavor PLAIN_DATA_FLAVOR = new DataFlavor("text/plain", "Plain text");
        public static final DataFlavor SERIALIZED_DATA_FLAVOR = new DataFlavor(String.class, "application/x-java-serialized-object; Plain text");
        private final TableModel model;

        public TableTransferable(TableModel model) {
            this.model = model;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{TABLE_DATA_FLAVOR, HTML_DATA_FLAVOR, CSV_DATA_FLAVOR, SERIALIZED_DATA_FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            System.out.println("isSupported " + flavor);
            boolean supported = false;
            for (DataFlavor mine : getTransferDataFlavors()) {
                if (mine.equals(flavor)) {
                    supported = true;
                    break;
                }
            }
            return supported;
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            System.out.println("get " + flavor);
            Object data = null;
            if (TABLE_DATA_FLAVOR.equals(flavor)) {
                data = model;
            } else if (HTML_DATA_FLAVOR.equals(flavor)) {
                data = new ByteArrayInputStream(formatAsHTML().getBytes());
            } else if (SERIALIZED_DATA_FLAVOR.equals(flavor)) {
                data = formatAsHTML();
            } else if (CSV_DATA_FLAVOR.equals(flavor)) {
                data = new ByteArrayInputStream("CSV".getBytes());
            } else {
                throw new UnsupportedFlavorException(flavor);
            }
            return data;
        }

        public String formatAsHTML() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("<html><body>");
            sb.append("<table>");
            sb.append("<tr>");
            for (int index = 0; index < model.getColumnCount(); index++) {
                sb.append("<th>").append(model.getColumnName(index)).append("</th>");
            }
            sb.append("</tr>");
            for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
                sb.append("<tr>");
                for (int colIndex = 0; colIndex < model.getColumnCount(); colIndex++) {
                    Object o = model.getValueAt(rowIndex, colIndex);
                    // You will want to format the value...
                    String value = o == null ? "" : o.toString();
                    sb.append("<td>").append(value).append("</td>");
                }
                sb.append("</tr>");
            }
            sb.append("</table>");

            return sb.toString();
        }
    }
}