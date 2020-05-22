public class PersonCallback implements Callback<TableColumn.CellDataFeatures<Person, String>, ObservableValue<String>> {

    private Function<Person,Object> extractor;

    public PersonCallback(Function<Person,Object> extractorFunction) {
        extractor = extractorFunction;
    }

    @Override
    public ObservableValue<String> call(TableColumn.CellDataFeatures<Person, String> cellData) {
        return new SimpleObjectProperty(extractor.apply(cellData.getValue()));
    }
}