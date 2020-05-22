view.getListBoxB().addChangeHandler(new ChangeHandler() {
    @Override
    public void onChange(ChangeEvent event) {
       eventBus.fireEvent(new ListBoxBEvent(selectedObject));
    }
});