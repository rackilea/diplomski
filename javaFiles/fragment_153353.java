public class FilterComboBoxTB extends ComboBox<String> {

    private ObservableList<String> initialList;

    public FilterComboBoxTB(@NamedArg("items") ObservableList<String> items) {
        super(items);
        // code as before ...
    }

    // ...
}