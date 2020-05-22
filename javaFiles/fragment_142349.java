public class MyGame extends Game {

    @Override
    public void create() {
        OrthographicCamera camera = new OrthographicCamera();
        TextureRegion cursorRegion = new TextureRegion(new Texture("myCursor.png"));
        MyCursor cursor = new MyCursor(cursorRegion);
        MyInput myInput = new MyInput(camera, cursor);
        Gdx.input.setInputProcessor(myInput);
    }
}