public class PlaySate extends State {
    private Texture bg;
    float sourceX = 0;

    public PlaySate(GameStateManager gsm) {
        super(gsm);
       bg=new Texture("bg.png");
       cam.setToOrtho(false,BuckyRun.WIDTH,BuckyRun.HEIGHT); // edited this
        bg.setWrap(Repeat,Repeat);
    }


    @Override
    public void render(SpriteBatch sb) {
        sourceX += 10;
        sb.setProjectionMatrix(cam.combined);
        sb.begin();

        // this line doesn't make much sense, you've already incremented sourceX, 
        // "Gdx.graphics.getDeltaTime() / 3/4" especially confuses me
        // why sourceX =% bg.getWidth(); isn't enough?
        sourceX = (sourceX + Gdx.graphics.getDeltaTime() / 3/4) % bg.getWidth();

        // you probably want to draw texture in full screen
        sb.draw(bg,
               // position and size of texture
               0, 0, WIDTH, HEIGHT, 
               // srcX, srcY, srcWidth, srcHeight
               (int) sourceX, 0, bg.getWidth(), bg.getHeight(),
               // flipX, flipY
               false, false);
        sb.end();

    }
}