FlowPanel flowPanel = new FlowPanel();
flowPanel.addHandler(new DOMNodeInsertedEventHandler() {
    @Override
    public void onDOMNodeInserted(DOMNodeInsertedEvent event) {
        Window.alert("Inserted");
    }
}, DOMNodeInsertedEvent.TYPE);
addDOMNodeInsertedEventHandler(flowPanel, flowPanel.getElement());