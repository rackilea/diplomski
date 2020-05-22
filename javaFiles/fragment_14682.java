ListView<Employee> listView = new ListView<>();
PseudoClass inactive = PseudoClass.getPseudoClass("inactive");
listView.setCellFactory(lv -> new ListCell<Employee>() {
    @Override
    protected void updateItem(Employee employee, boolean empty) {
        super.updateItem(employee, empty);
        if (empty) {
            setText(null);
            pseudoClassStateChanged(inactive, false);
        } else {
            if (employee.isActive()) {
                setText(employee.getName());
                pseudoClassStateChanged(inactive, false);
            } else {
                setText(employee.getName() + " - not active");
                pseudoClassStateChanged(inactive, true);
            }
        }
    }
});