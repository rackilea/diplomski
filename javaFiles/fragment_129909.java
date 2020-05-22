public interface CommonCssBundle extends ClientBundle {
    public static final CommonCssBundle INSTANCE = GWT.create(CommonCssBundle.class);

    @Source("path/to/your/css/file/here/split-css-override.css")
    public CssResource css();
}