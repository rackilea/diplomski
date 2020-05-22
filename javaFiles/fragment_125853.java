public interface MyResources extends ClientBundle {
    public static final MyResources INSTANCE = GWT.create(MyResources.class);
    @Source("dastylez.css")
    @CssResource.NotStrict
    CssResource css();
}