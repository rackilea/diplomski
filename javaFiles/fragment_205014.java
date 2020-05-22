lastNameCol.setOnEditCommit(
    (CellEditEvent<Person, String> t) -> {
        t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                .setLastName(t.getNewValue());
});