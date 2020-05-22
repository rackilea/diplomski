ContextMenu cm = new ContextMenu();
MenuItem mi1 = new MenuItem("Menu 1");
cm.getItems().add(mi1);
MenuItem mi2 = new MenuItem("Menu 2");
cm.getItems().add(mi2);

table.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

    @Override
    public void handle(MouseEvent t) {
        if(t.getButton() == MouseButton.SECONDARY) {
            cm.show(table, t.getScreenX(), t.getScreenY());
        }
    }
});