TableColumn<Appointment, String> column = ...

column.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Appointment, String>, ObservableValue<String>> {
    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Appointment, String> cd) {
        Appointment a  = cd.getValue();

        return Bindings.createStringBinding(() -> "the year: " + a.getDate().getYear(), a.dateProperty());
    }

});