@Root(strict = false)
@Convert(value = PropertyValueConverter.class)
public class PropertyValue {
    private List<ItemData> items;

    private String text;

    public List<ItemData> getItems() {
        return items;
    }

    public void setItems(List<ItemData> items) {
        this.items = items;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}