Draggable draggable = new Draggable(framedPanel, framedPanel.getHeader());
//assuming GXT 3, just guessing from your post
draggable.addDragStartHandler(new DragStartHandler() {
  public void onDragStart(DragStartEvent event) {
    //...
  }
});