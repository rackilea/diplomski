import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            DefaultListModel<String> model = new DefaultListModel<>();
            model.addElement("Cooks_Assistant");
            model.addElement("Romeo_and_Juliet");
            model.addElement("Sheep_Shearer");

            JList list = new JList(model);
            list.setTransferHandler(new HListItemTransferHandler());
            list.setDragEnabled(true);

            JLabel noDrop = new JLabel("No drop here", JLabel.CENTER);
            JLabel trash = new JLabel("All your trash belong to us", JLabel.CENTER);
            trash.setTransferHandler(new BinTransferHandler());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0.5;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(4, 4, 4, 4);

            add(new JScrollPane(list), gbc);

            gbc.gridx++;
            add(noDrop, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(trash, gbc);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

    }

    public class BinTransferHandler extends TransferHandler {

        @Override
        public boolean canImport(TransferSupport info) {
            return info.isDataFlavorSupported(TrashTransferable.FLAVOR);
        }

        @Override
        public int getSourceActions(JComponent c) {
            System.out.println("ACTION");
            return DnDConstants.ACTION_MOVE;
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }
            // Check target component
            Transferable transferable = support.getTransferable();
            try {
                Trash trash = (Trash) transferable.getTransferData(TrashTransferable.FLAVOR);
                Object item = trash.getItem();
                System.out.println(">> Trash " + item);

                return true;
            } catch (UnsupportedFlavorException | IOException ex) {
                ex.printStackTrace();
            }
            return false;
        }

    }

    public class HListItemTransferHandler<T> extends TransferHandler {

        @Override
        protected Transferable createTransferable(JComponent component) {
            System.out.println("createTransferable");
            JList<T> list = (JList<T>) component;
            int index = list.getSelectedIndex();
            T transferredObject = list.getSelectedValue();
            return new TrashTransferable(new ListTrash<>(list, index, transferredObject));
        }

        @Override
        public boolean canImport(TransferSupport info) {
            return info.isDataFlavorSupported(TrashTransferable.FLAVOR);
        }

        @Override
        public int getSourceActions(JComponent c) {
            return DnDConstants.ACTION_MOVE;
        }

        @Override
        public boolean importData(TransferSupport info) {
            JList<Object> target = (JList<Object>) info.getComponent();
            JList.DropLocation dl = (JList.DropLocation) info.getDropLocation();
            DefaultListModel<Object> listModel = (DefaultListModel<Object>) target.getModel();
            int index = dl.getIndex();
            int max = listModel.getSize();

            if (index < 0 || index > max) {
                index = max;
            }

            try {
                Object object = info.getTransferable().getTransferData(DataFlavor.stringFlavor);
                listModel.add(index, object);
                target.addSelectionInterval(index, index);
                return true;
            } catch (UnsupportedFlavorException | IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void exportDone(JComponent c, Transferable data, int action) {
            System.out.println("Export data");
            try {
                if (action != MOVE) {
                    return;
                }
                if (!(c instanceof JList)) {
                    return;
                }
                JList list = (JList) c;
                if (!(list.getModel() instanceof DefaultListModel)) {
                    return;
                }
                DefaultListModel model = (DefaultListModel) list.getModel();
                if (!(data instanceof TrashTransferable)) {
                    return;
                }
                Object transferData = data.getTransferData(TrashTransferable.FLAVOR);
                if (transferData == null || !(transferData instanceof Trash)) {
                    return;
                }
                Trash trash = (Trash) transferData;
                Object item = trash.item;
                int index = model.indexOf(item);
                if (index == -1) {
                    return;
                }
                model.remove(index);
            } catch (UnsupportedFlavorException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static class ListTrash<T> extends Trash<T> {

        private JList list;
        private int index;

        public ListTrash(JList list, int index, T item) {
            super(item);
            this.list = list;
            this.index = index;
        }

        public JList getList() {
            return list;
        }

        public int getIndex() {
            return index;
        }

    }

    public static class Trash<T> {

        private T item;

        public Trash(T item) {
            this.item = item;
        }

        public T getItem() {
            return item;
        }

    }

    public static class TrashTransferable<T> implements Transferable {

        public static final DataFlavor FLAVOR = new DataFlavor(Trash.class, "Trash");

        private Trash<T> trash;

        TrashTransferable(Trash<T> object) {
            trash = object;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            return trash;
        }
    }
}