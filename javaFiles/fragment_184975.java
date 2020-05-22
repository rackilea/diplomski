MenuItem menuItem = new MenuItem("Exit");
menuItem.setOnAction(new EventHandler<ActionEvent>() {
    @Override public void handle(ActionEvent e) {
        System.exit(0);
    }
});
menu.getItems().add(menuItem);