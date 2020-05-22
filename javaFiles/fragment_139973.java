private void onButtonClick(Button.ClickEvent clickEvent) {
    Value newValue = new Value("New value");
    list.add(newValue);
    grid.getDataProvider().refreshAll();
    grid.focus();
}