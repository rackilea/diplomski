@Override
public void initialize(URL location, ResourceBundle resources) {
    one.setUserData(SelectionMode.ONE);
    two.setUserData(SelectionMode.TWO);
    three.setUserData(SelectionMode.THREE);

    selectionMode.bind(Bindings.createObjectBinding(() -> {
        Toggle selectedToggle = menuSelection.getSelectedToggle();
        return (SelectionMode) selectedToggle.getUserData();
    }, menuSelection.selectedToggleProperty()));
}