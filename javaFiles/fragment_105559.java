@Override
protected Widget createWidget() {
    MyWidget widget = GWT.create(MyWidget.class);
    widget.addMyListener(new MyListener() {
        @Override
        public void onSomeEvent(ClientData data) {
            rpc.onEventFromClient(data);
        }
    });
    return widget;
}