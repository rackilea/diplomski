/**
 * The user can move list items between two lists using drag and drop
 * @author Matthias Braun
 *
 */
public class BidirectionalDragAndDrop extends JFrame {
    private static final long serialVersionUID = 1L;

    public BidirectionalDragAndDrop() {

        JList<String> source = createJListWithDragAndDrop();
        source.setModel(createSourceListModel());
        JList<String> target = createJListWithDragAndDrop();
        target.setModel(new DefaultListModel<String>());

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, source, target);
        JLabel label = new JLabel("You can drag the fruits from the left list to the right and vice versa");

        add(splitPane);
        add(label, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private JList<String> createJListWithDragAndDrop() {
        JList<String> list = new JList<>();
        list.setDragEnabled(true);
        list.setDropMode(DropMode.INSERT);
        StringMoveHandler.createFor(list);

        return list;
    }

    private static DefaultListModel<String> createSourceListModel() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String str : Arrays.asList("Papaya", "Orange", "Apple", "Mango", "Pear", "Avocado")) {
            listModel.addElement(str);
        }
        return listModel;
    }

    /**
     * Handles the moving of one or multiple strings between {@link JList}s.
     * 
     * @author Matthias Braun
     *
     */
    private static class StringMoveHandler extends TransferHandler {
        private static final long serialVersionUID = 1L;
        private DataFlavor objectArrayFlavor = new ActivationDataFlavor(Object[].class, DataFlavor.javaJVMLocalObjectMimeType, "Array of items");
        // We'll be moving the strings of this list
        private JList<String> list;

        // Clients should use a static factory method to instantiate the handler
        private StringMoveHandler() {
        };

        public static StringMoveHandler createFor(JList<String> list) {
            StringMoveHandler handler = new StringMoveHandler();
            list.setTransferHandler(handler);
            handler.list = list;
            return handler;
        }

        @Override
        public boolean canImport(TransferSupport info) {
            return info.isDataFlavorSupported(objectArrayFlavor);
        }

        @Override
        public boolean importData(TransferSupport transferSupport) {
            Transferable t = transferSupport.getTransferable();

            boolean success = false;
            try {
                Object[] importedData = (Object[]) t.getTransferData(objectArrayFlavor);
                addToListModel(importedData);
                success = true;
            }
            catch (UnsupportedFlavorException | IOException e) {
                e.printStackTrace();
            }
            return success;
        }

        private void addToListModel(Object[] importedData) {
            JList.DropLocation loc = list.getDropLocation();
            int dropIndex = loc.getIndex();

            DefaultListModel<String> listModel = (DefaultListModel<String>) list.getModel();
            for (int i = 0; i < importedData.length; i++) {
                Object elem = importedData[i];
                if (elem instanceof String) {
                    listModel.add(dropIndex + i, (String) elem);
                }
                else {
                    System.err.println("Imported data contained something else than strings: " + elem);
                }
            }
        }

        @Override
        public int getSourceActions(JComponent c) {
            return TransferHandler.COPY_OR_MOVE;
        }

        @Override
        public Transferable createTransferable(JComponent source) {
            // We need the values from the list as an object array, otherwise the data flavor won't match in importData
            @SuppressWarnings("deprecation")
            Object[] valuesToTransfer = list.getSelectedValues();
            return new DataHandler(valuesToTransfer, objectArrayFlavor.getMimeType());
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
            if (action == TransferHandler.MOVE) {
                try {
                    Object[] exportedData = (Object[]) data.getTransferData(objectArrayFlavor);
                    removeFromListModel(exportedData);
                }
                catch (UnsupportedFlavorException | IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void removeFromListModel(Object[] dataToRemove) {
            DefaultListModel<String> listModel = (DefaultListModel<String>) list.getModel();
            for (Object elemToRemove : dataToRemove) {
                boolean removedSuccessfully = listModel.removeElement(elemToRemove);
                if (!removedSuccessfully) {
                    System.err.println("Source model did not contain exported data");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new BidirectionalDragAndDrop();
                }
                catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}