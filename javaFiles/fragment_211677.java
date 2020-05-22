firstCol.setOnEditCommit(new EventHandler<EditEvent<String>>() {
    @Override
    public void handle(EditEvent<String> event) {
        String newValue = event.getNewValue();
        ContactOptions data = (ContactOptions) event.getTableView().getItems().get(event.getTablePosition().getRow());
        data.one.set(newValue)
        if(newValue.equals("No")) {
            data.three.set("No");
            data.four.set("No");
        }
    }
}