public class CssClassRemover extends AttributeModifier {
    public CssClassRemover(String cssClass) {
        super("class", false, new Model<String>(cssClass));
    }

    @Override
    protected String newValue(String currentValue, String valueToRemove) {
        // NB: naive approach; breaks with e.g. "foo foo-bar" & "foo"
        return currentValue.replaceAll(valueToRemove, "");
    }
}