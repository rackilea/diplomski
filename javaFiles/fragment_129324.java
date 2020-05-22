public class Person {

    public Person(String name0, int age0) {
        name = name0;
        age = age0;
    }
    public String name;
    public int age;
}        

TableView<Person> personTable = new TableView<>();

TableColumn<Person, Number> age = new TableColumn<>();

age.setCellValueFactory(new Callback<CellDataFeatures<Person, Number>, ObservableValue<Number>>() {
    @Override
    public ObservableValue<Number> call(CellDataFeatures<Person, Number> p) {
        return new SimpleIntegerProperty(p.getValue().age);
} 
});

age.setCellFactory(TextFieldTableCell.<Person, Number>forTableColumn(new NumberStringConverter()));