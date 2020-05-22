lstFiles.setDropTarget(new DropTarget()
{
    @Override
    public synchronized void drop(DropTargetDropEvent dtde) 
    {
        this.changeToNormal();
        //handle the drop... [...]
    }

    @Override
    public synchronized void dragEnter(DropTargetDragEvent dtde) 
    {
        //Change cursor...
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        setCursor(cursor);

        //Change JList background...
        lstFiles.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public synchronized void dragExit(DropTargetEvent dtde) 
    {
        this.changeToNormal();
    }

    private void changeToNormal()
    {
        //Set cursor to default.
        Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        setCursor(cursor);

        //Set background to normal...
        lstFiles.setBackground(Color.WHITE);
    }
});