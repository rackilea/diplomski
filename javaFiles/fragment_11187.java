public void onModuleLoad() {
    Label label = new Label("Text");
    final MyDialogBox mDBox = new MyDialogBox(label);
    Button btn = new Button("Click me!");

    btn.addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            mDBox.center();
            mDBox.show();
        }
    });
    RootPanel.get().add(label);
    RootPanel.get().add(btn);
}