class DraggableLabel extends JLabel implements DragGestureListener, DragSourceListener {

    private DragSource dragSource;

    DraggableLabel(String text) {
        super(text);

        // create the drag source
        dragSource = new DragSource();
        // assign this component a DragGestureRecognizer
        dragSource.createDefaultDragGestureRecognizer(
                this, DnDConstants.ACTION_COPY_OR_MOVE, this);

        // for contrast with other items in layered pane
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent evt) {
        dragSource.startDrag(
                evt, //trigger event
                DragSource.DefaultMoveDrop, // icon
                new StringSelection(getText()), // transferable data
                this); // this the DragSourceListener
    }

    @Override
    public void dragEnter(DragSourceDragEvent evt) {}

    @Override
    public void dragOver(DragSourceDragEvent evt) {}

    @Override
    public void dragExit(DragSourceEvent evt) {}

    @Override
    public void dropActionChanged(DragSourceDragEvent evt) {}

    @Override
    public void dragDropEnd(DragSourceDropEvent evt) {}

}