layeredPane.setDropTarget(new DropTarget() {

    @Override
    public synchronized void drop(DropTargetDropEvent dtde) {
        try {
            // create draggable label to add to layered pane 
            // creating this class will be explained next
            final DraggableLabel label = new DraggableLabel(
                    (String) dtde.getTransferable()
                    .getTransferData(DataFlavor.stringFlavor));

            // add label to layered pane
            layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);
            layeredPane.revalidate();
            layeredPane.repaint();
        } catch(UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
    }

});