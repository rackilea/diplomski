ProxyPipe fromViewer = viewer.newViewerPipe();
fromViewer.addSink(new SinkAdapter(){
    @Override
    public void nodeAttributeAdded(String sourceId, long timeId, String nodeId, String attribute, Object value) {
        if(attribute.equals("ui.clicked")){
            // Being notified that a node was clicked...
        }
    }
});