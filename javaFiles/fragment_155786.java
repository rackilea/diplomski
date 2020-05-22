private OrthographicCamera camera;
private BodyDef bodyDef;
private Body body;
private PolygonShape box;
static float WORLD_TO_BOX, BOX_TO_WORLD, bodyWidth, bodyHieght;

public Create(){
    //Conversion factors
    WORLD_TO_BOX = 1/32f;  
    BOX_TO_WORLD = 1/WORLD_TO_BOX;

    //Creation of the camera with your factor 32
    camera = new OrthographicCamera();
    camera.viewportHeight = Gdx.graphics.getHeight() * WORLD_TO_BOX;  
    camera.viewportWidth = Gdx.graphics.getWidth() * WORLD_TO_BOX;  
    camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);  
    camera.update();  

    //Let's say you want to create a body in the center of your screen
    BodyDef = new BodyDef();  
    BodyDef.position.set(new Vector2(camera.viewportWidth/2, -camera.viewportHeight/2));  
    body = world.createBody(BodyDef);  
    box = new PolygonShape();  
    //Let's say you want your body to have the shape of a square which sides size is one fifth of your camera width
    bodyWidth = camera.viewportWidth/10;
    bodyHeight = camera.viewportWidth/10;
    box.setAsBox(bodyWidth, bodyHeight);
    body.createFixture(box, 0.0f);
}