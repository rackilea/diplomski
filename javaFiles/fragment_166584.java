public interface AppBundle extends ClientBundle {

    @Source("image.png")
    ImageResource myImage();

    public static final AppBundle INSTANCE = GWT.create(AppBundle.class);

}