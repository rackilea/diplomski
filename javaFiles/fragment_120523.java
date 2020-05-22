public class TestGame extends Game implements InputProcessor{

    Stage stage;
    Image image;
    Group group;
    Vector2 vector2=new Vector2();

    @Override
    public void create() {

        stage=new Stage();
        group=new Group();

        Gdx.input.setInputProcessor(this);

        image=new Image(new Texture("image/base.png"));
        image.setPosition(100,100);

        group.addActor(image);
        stage.addActor(group);

        System.out.println("Initial Position of Actor : "+image.getX()+" And "+image.getY());
    }

    @Override
    public void render() {
        super.render();

        Gdx.gl.glClearColor(1,1,1,1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width,height);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        System.out.println("Actor Position Before moveBy on Group is : "+image.getX()+" And "+image.getY());

        group.moveBy(50,50);

        System.out.println("After moveBy applied on Group, Actor Position is : "+image.getX()+"And"+image.getY());
        vector2.set(image.getX(),image.getY());
        Vector2 stageCord=group.localToStageCoordinates(vector2);
        System.out.println("Position with Stage Cord. is : "+stageCord.x+" And "+stageCord.y);

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}