public class PersonCell extends ListCell<Person> {
    private final Label firstNameLabel ;
    private final Label lastNameLabel ;

    private final GridPane listCellContents ;

    public PersonCell() {
        listCellContents = new GridPane();
        listCellContents.setPadding(new Insets(10, 10, 10, 10));
        listCellContents.setHgap(10);
        listCellContents.setVgap(10);

        firstNameLabel = new Label();
        lastNameLabel = new Label();

        Button deleteReccord = new Button("Delete");
        deleteReccord.setOnAction(e -> { 
            Person person = getItem();
            getListView().getItems().remove(person);
        });


        listCellContents.add(firstNameLabel, 0, 0);
        listCellContents.add(lastNameLabel, 0, 1);
        listCellContents.add(deleteReccord, 1, 0, 1, 2);

        ColumnConstraints leftCol = new ColumnConstraints();
        ColumnConstraints rightCol = new ColumnConstraints();

        rightCol.setHalignment(HPos.RIGHT);
        rightCol.setHgrow(Priority.ALWAYS);

        listCellContents.getColumnConstraints().addAll(leftCol, rightCol);

    }

    @Override
    public void updateItem(Person item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            firstNameLabel.setText(item.getFirstName());
            lastNameLabel.setText(item.getLastName());
            setGraphic(listCellContents);
        }
    }
}