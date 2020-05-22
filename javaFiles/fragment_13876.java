final FlowLayoutContainer dropContainer = new FlowLayoutContainer();
dropContainer.setBorders(true);

DropTarget target = new DropTarget(dropContainer) {
@Override
protected void onDragDrop(DndDropEvent event) {
     super.onDragDrop(event);
     Window window = new Window();
     window.setClosable(true);
     window.setHeight(200);
     window.setWidth(200);
};
target.setGroup("test");
target.setOverStyle("drag-ok");
}