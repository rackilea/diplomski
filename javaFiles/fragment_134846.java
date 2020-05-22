public class MainGame extends ApplicationAdapter {
    SpriteBatch batch;
    private Texture Statektekstura,Pocisktekstura;
    private Statek statek;
    Array<Pocisk> pociskList;
    boolean oneAtOnce;

    @Override
    public void create () {
        zaladujdane();
        init();
    }

    private void init() {
        batch=new SpriteBatch();
        statek=new Statek(Statektekstura);
        pociskList=new Array<Pocisk>();
    }

    private void zaladujdane() {
        //tekstura statku pomniejszana
        Pixmap pixmap2 = new Pixmap(Gdx.files.internal("badlogic.jpg"));
        Pixmap pixmap1 = new Pixmap(100, 100, pixmap2.getFormat());
        pixmap1.drawPixmap(pixmap2,
                0, 0, pixmap2.getWidth(), pixmap2.getHeight(),
                0, 0, pixmap1.getWidth(), pixmap1.getHeight()
        );
        Statektekstura=new Texture(pixmap1);

        //tekstura pocisk pomniejszona
        Pixmap pixmap20 = new Pixmap(Gdx.files.internal("badlogic.jpg"));
        Pixmap pixmap10 = new Pixmap(35, 35, pixmap20.getFormat());
        pixmap10.drawPixmap(pixmap20,
                0, 0, pixmap20.getWidth(), pixmap20.getHeight(),
                0, 0, pixmap10.getWidth(), pixmap10.getHeight()
        );

        Pocisktekstura=new Texture(pixmap10);
    }

    @Override
    public void render () {
        udpdate();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        statek.draw(batch);
        for(Pocisk pocisk:pociskList)
             pocisk.draw(batch);

        batch.end();
    }

    private void udpdate() {
        przesuwanie();
        for (Pocisk pocisk:pociskList)
        pocisk.y=pocisk.y+pocisk.pociskpredkosc*Gdx.graphics.getDeltaTime();
    }

    private void przesuwanie() {
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            statek.x=statek.x-250*Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Keys.D))
        {
            statek.x=statek.x+250*Gdx.graphics.getDeltaTime();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            Pocisk pocisk=new Pocisk(Pocisktekstura); //Called in game render method so create number of Object 
            pocisk.strzal();
            pociskList.add(pocisk);

        }
    }

    @Override
    public void dispose () {
        //batch.dispose();
    }
}