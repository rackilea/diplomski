public class I18N {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("content");

    public static String getString(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}