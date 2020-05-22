private List<TableColumn> createColumns(ObservableList<Person> persons) {
        List<TableColumn> columns = new ArrayList();

        for(int i = 0; i < getNumberOfFavoriteColumn(persons); i++) {
            final int index = i;
            TableColumn column = new TableColumn(String.format("Favorite Number %d", i + 1));
            column.setCellValueFactory(new PersonCallback((person) -> { return person.getNumbers().size() > index ? person.getNumbers().get(index) : "";}));
            columns.add(column);
        }

        return columns;
    }