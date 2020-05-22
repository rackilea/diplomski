private OrthographicCamera camera;
private SpriteBatch batch;
private Texture img;

@Override
public void create () {
    //We create a OrthographicCamera through which we see 50x50 World Units
    camera = new OrthographicCamera(50,50);
    batch = new SpriteBatch();
    img = new Texture("badlogic.jpg");
}