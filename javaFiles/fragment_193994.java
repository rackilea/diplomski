public class TableViewTest {

    ...

    private final StringProperty option = new SimpleStringProperty();

    public String getOption() {
        return option.get();
    }

    public void setOption(String value) {
        option.set(value);
    }

    public StringProperty optionProperty() {
        return option;
    }

}