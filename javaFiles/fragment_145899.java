package your.name.package;
//
public class MyGdxGame extends ApplicationAdapter {

    /**
     * Holds all our assets
     */
    public AssetManager manager = new AssetManager();

    @Override
    public void create() {
        setScreen(new LoadingScreen(this));
    }
}