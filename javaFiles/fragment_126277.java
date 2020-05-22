FlowPanel myButton = new FlowPanel();
myButton.add(new Image(icon));
myButton.add(new Label(myButtonText));

ClickHandler h = new ClickHandler() {
    @Override
    public void onClick(ClickEvent event) {
        // do something
    }
};
myButton.addDomHandler(h, ClickEvent.getType());