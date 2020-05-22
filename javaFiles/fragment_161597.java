public CustomComposite() {
    Button b = new Button("Pop it up");
    b.addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
            new CustomDialog().show();
        }
    });
    initWidget(b);
}