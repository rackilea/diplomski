public class AttributeColumnGenerator implements Table.ColumnGenerator {

public Object generateCell(Table source, Object itemId, Object columnId) {

    String textToDisplay  = (String)source.getItem(itemId).getItemProperty(columnId).getValue();
    return new Label(textToDisplay);
}