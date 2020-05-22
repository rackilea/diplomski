public void onModuleLoad() {

    final RootPanel rootPanel = RootPanel.get();

    final ListBox listBox = new ListBox();
    listBox.addItem("Alpha");
    rootPanel.add(listBox);

    final Button button = new Button("Button");
    button.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(final ClickEvent event) {
            listBox.addItem("Beta");
        }
    });
    rootPanel.add(button);

}