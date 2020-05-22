grid.addComponentColumn(person -> {
    Button button = new Button("Click me!");
    button.addClickListener(click ->
        Notification.show("Clicked: " + person.toString()));
    return button;
});
// make sure the buttons fit in the cells of the Grid
grid.setBodyRowHeight(40);