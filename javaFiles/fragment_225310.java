@Override
protected void exportDone(JComponent source, Transferable data, int action) {
    if (action != MOVE) {
        return;
    }
    DefaultTreeModel model = (DefaultTreeModel) ((JTree) source).getModel();
    try {
        model.removeNodeFromParent((ObjectNode) data.getTransferData(DataFlavors.ORDataFlavor));
    } catch (UnsupportedFlavorException | IOException ex) {
        Logger.getLogger(ORDnd.class.getName()).log(Level.SEVERE, null, ex);
    }

}