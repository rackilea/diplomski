public class Validation {
    private String          text    = null;
    private ValidationType  type    = ValidationType.OK;

    public Validation(String text, ValidationType type) {
        super();
        this.text = text;
        this.type = type;
    }
    public String getText() {
        return text;
    }
    public ValidationType getType() {
        return type;
    }
}