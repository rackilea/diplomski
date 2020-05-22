@Tag("multiselect-combo-box")
@HtmlImport("src/views/common/multiselect-combo-box.html")
public class MultiSelectComboBox extends AbstractCallableComponent {

    private List<String> value;

    public void setItems(List<String> items) {
        JsonArray arr = Json.createArray();

        items.forEach(item -> {
            arr.set(arr.length(), item);
        });
        getElement().setPropertyJson("items", arr);
    }

    @ClientCallable
    @Override
    public void onValueChange(String s) {
        if (s.length() == 0) {
            value = Collections.emptyList();
        } else {
            value = Arrays.stream(s.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
        }
        fireEvent(new ChangeEvent(this, false));
    }

    @Override
    public List<String> getValue() {
        return value;
    }

    public Registration addChangeListener(ComponentEventListener<ChangeEvent> listener) {
        return addListener(ChangeEvent.class, listener);
    }
}