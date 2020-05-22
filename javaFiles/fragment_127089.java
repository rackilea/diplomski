package com.mygdx.gtest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class Test extends ApplicationAdapter {

    private SpriteBatch batch;
    private World world;
    private BodyDef bodyDef;
    private Body body;
    private Texture texture;
    private Sprite sprite;
    private Box2DDebugRenderer debugRenderer;
    private ExtendViewport viewport;

    @Override
    public void create() {
        debugRenderer = new Box2DDebugRenderer(true,true,true,true, true, true);
        viewport = new ExtendViewport(64,48); // adding viewport so we can use multiple resolutions easily
        viewport.getCamera().position.set(32, 24, 0); // set cam position to make 0,0 bottom left corner
        batch = new SpriteBatch();
        batch.setProjectionMatrix(viewport.getCamera().combined); // tell the batch how things should be rendered 
        texture = new Texture("badlogic.jpg");
        sprite = new Sprite(texture);
        sprite.setSize(10,10); // set the size of the sprite in box2d units (10 meters x 10 meters)

        // not needed as position is set in update method
        //sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2,   Gdx.graphics.getHeight() / 2);

        world = new World(new Vector2(0, -10), true);

        bodyDef = new BodyDef();

        bodyDef.type = BodyDef.BodyType.DynamicBody;

        bodyDef.position.set(32 , 47);
        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(5,5);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        Fixture fixture = body.createFixture(fixtureDef);

        shape.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height); 
    }

    @Override
    public void render() {
        world.step(Gdx.graphics.getDeltaTime(), 8, 3);

        sprite.setPosition(body.getPosition().x - (sprite.getWidth()/2), body.getPosition().y -(sprite.getHeight()/2));

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(viewport.getCamera().combined);  // tell the batch how things should be rendered incase of resized window
        batch.begin();
        batch.draw(sprite, sprite.getX(), sprite.getY(),sprite.getWidth(),sprite.getHeight());
        batch.end();

        System.out.println(body.getLinearVelocity().y);

        debugRenderer.render(world, viewport.getCamera().combined);
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
        world.dispose();
        debugRenderer.dispose();
    }
}