public class I18nTextBox extends I18nAbstractTextBox<String> {
    public I18nTextBox() {
        super();
    }
    public I18nTextBox(String keyTitle) {
        super(keyTitle);
    }
    public I18nTextBox(String keyTitle, int maxLength, String ... substitutions) {
        super(keyTitle, maxLength, substitutions);
    }
    //...
}