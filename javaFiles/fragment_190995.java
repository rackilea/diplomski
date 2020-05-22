public class TestGame extends ApplicationAdapter
{
    private Skin    skin;
    private Stage   stage;
    private Texture t;

    @Override
    public void create()
    {
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        t = new Texture(Gdx.files.internal("badlogic.jpg"));

        // So we see everything
        stage = new Stage(new ExtendViewport(4000, 400));

        HorizontalGroup hGroup = new HorizontalGroup();
        hGroup.setFillParent(true);

        // So that the hGroup is on top
        Table filler = new Table(skin);
        filler.setFillParent(true);
        filler.add(hGroup).fill().center();

        stage.addActor(filler);

        for (int i = 0; i < 10; i++)
        {
            final ImageButton b = new ImageButton(
                    new TextureRegionDrawable(new TextureRegion(t)));
            b.addListener(new ClickListener()
            {

                @Override
                public void clicked(InputEvent event, float x, float y)
                {
                    if (b.getParent().equals(hGroup))
                    {
                        stage.addActor(b);
                        b.setPosition(
                                (stage.getWidth() - b.getWidth()) / 2f,
                                (stage.getHeight() - b.getHeight()) / 2f);
                    } else
                    {
                        hGroup.addActor(b);
                    }
                }
            });
            hGroup.addActor(b);
        }

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void resize(int width, int height)
    {
        stage.getViewport().update(width, height);
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void dispose()
    {
        stage.dispose();
        skin.dispose();
        t.dispose();
    }
}