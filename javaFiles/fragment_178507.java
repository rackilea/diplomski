import com.badlogic.gdx.ApplicationListener;
    import com.badlogic.gdx.Gdx;
    import com.badlogic.gdx.graphics.GL20;
    import com.badlogic.gdx.graphics.Texture;
    import com.badlogic.gdx.graphics.Texture.TextureFilter;
    import com.badlogic.gdx.graphics.g2d.TextureRegion;
    import com.badlogic.gdx.scenes.scene2d.InputEvent;
    import com.badlogic.gdx.scenes.scene2d.Stage;
    import com.badlogic.gdx.scenes.scene2d.ui.Image;
    import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

    public class MyGame implements ApplicationListener {

        private Stage mStage;

        @Override
        public void create() {
            mStage = new Stage(0, 0, true);

            Texture texture = new Texture(Gdx.files.internal("data/libgdx.png"));
            texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
            TextureRegion region = new TextureRegion(texture, 0, 0, 40, 40);

            for (int y = 0; y < 4; ++y) {
                for (int x = 0; x < 4; ++x) {
                    Image imageActor = new Image(region);
                    imageActor.setPosition(x * 50, y * 50);
                    imageActor.addListener(new ClickListener() {
                       public void clicked(InputEvent event, float x, float y) {
                            System.out.println("clicked");
                        }
                    });
                    mStage.addActor(imageActor);
                }
            }

            Gdx.input.setInputProcessor(mStage);
        }

        @Override
        public void resize(int width, int height) {
            Gdx.gl.glViewport(0, 0, width, height);
            mStage.setViewport(width, height);
        }

        @Override
        public void render() {
            mStage.act(Gdx.graphics.getDeltaTime());
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            mStage.draw();        
        }

        @Override
        public void pause() {}

        @Override
        public void resume() {}

        @Override
        public void dispose() {}    
    }