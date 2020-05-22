combobox.setCellFactory(new Callback<ListView<Employee>, ListCell<Employee>>() {

    @Override
    public ListCell<Employee> call(ListView<Employee> arg0) {
        return new ListCell<Employee>() {

            private final Button btn;
            {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                btn = new Button();
            }

            @Override
            protected void updateItem(Employee item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    btn.setStyle(item.getSalary() > 1000 ? "-fx-base:red" : "-fx-base: green");
                    btn.setText(item.getName() + "=" + item.getSalary());
                    setGraphic(btn);
                }
            }
        };
    }
});