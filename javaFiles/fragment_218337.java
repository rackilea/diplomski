class Game extends ApplicationAdapter {

    Vector2 position = new Vector2();
    Vector2 velocity = new Vector2();
    Vector2 movement = new Vector2();
    Vector2 touch = new Vector2();
    Vector2 dir = new Vector2();

    Vector3 temp = new Vector3();

    float speed = 100;

    OrthographicCamera camera;

    SpriteBatch batch;
    Texture texture;
    Sprite sprite;

    @Override
    public void create () {
        camera = new OrthographicCamera();
        camera.setToOrtho(false);

        batch = new SpriteBatch();

        texture = new Texture(Gdx.files.internal("data/badlogicsmall.jpg"));

        sprite = new Sprite(texture);

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown (int screenX, int screenY, int pointer, int button) {
                camera.unproject(temp.set(screenX, screenY, 0));
                touch.set(temp.x, temp.y);
                return true;
            }
        });
    }

    @Override
    public void render () {
        Gdx.gl10.glClear(GL10.GL_COLOR_BUFFER_BIT);
        update(Gdx.graphics.getDeltaTime());
        batch.begin();
        sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        texture.dispose();
        batch.dispose();            
    }
    public void update (float deltaTime) {
        position.set(sprite.getX(), sprite.getY());
        dir.set(touch).sub(position).nor();
        velocity.set(dir).scl(speed);
        movement.set(velocity).scl(deltaTime);
        if (position.dst2(touch) > movement.len2()) {
            position.add(movement); 
        } else {
            position.set(touch);
        }               
        sprite.setX(position.x);
        sprite.setY(position.y);
    }
}