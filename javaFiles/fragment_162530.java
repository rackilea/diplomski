target.addDropHandler(new DndDropHandler() {
    @Override
    public void onDrop(DndDropEvent event) {
        final TreeNode<MyModel> item = source.getWidget().findNode(event.getDragEndEvent().getNativeEvent().getEventTarget().<Element> cast());
        MyModel newParent = item.getModel();
    }
});