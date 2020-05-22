public class CustomDoubleEditor extends PropertyEditorSupport {
    public CustomDoubleEditor() {
    }

    public String getAsText() {
        Double d = (Double) getValue();
        return d.toString();
    }

    public void setAsText(String str) {
        if (str == "" || str == null)
            setValue(0);
        else
            setValue(Double.parseDouble(str));
    }
}