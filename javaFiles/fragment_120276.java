public class OneLineTextField extends HorizontalFieldManager {
    private EditField _editField;

    public OneLineTextField(String label, String initialValue, int maxChars, long style) {
        super(HORIZONTAL_SCROLL);
        editField = new EditField(label, initialValue, maxChars, style | EditField.NO_NEWLINE | EditField.FOCUSABLE | EditField.EDITABLE);
        add(editField);
    }

    public String getText() {
        return editField.getText();
    }
    ...
}