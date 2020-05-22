import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Prac1 extends ApplicationAdapter {
    float w,h,tw,th =0;
    OrthographicCamera camera;
    SpriteBatch batch;
    Sprite img;

    @Override
    public void create () {
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(w, h);
        camera.position.set(w/2, h/2, 0);
        camera.update();
        batch = new SpriteBatch();
        img = new Sprite(new Texture(Gdx.files.internal("iceCream.png")));

        tw = img.getWidth();
        th = img.getHeight();
        img.setBounds( camera.position.x - (tw/2), camera.position.y - (th/2),tw,th);
        Gdx.input.setInputProcessor(new InputAdapter(){

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {

                if(img.getBoundingRectangle().contains(screenX, screenY))
                       System.out.println("Image Clicked");

                return true;
            }

        });
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        img.draw(batch);
        batch.end();
    }
}