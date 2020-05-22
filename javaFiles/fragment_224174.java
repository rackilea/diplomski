public class MenuScreen extends InputAdapter implements Screen {

    ...

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        ...
    }

    ...
}