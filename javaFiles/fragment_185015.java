public class Main {
    private Array<Coin> coins = new Array<>();

    public void create(){
        TextureRegion region = assets.getAtlas().findRegion("Gold");
        for(MapObject mapObject : mapObjects){
            Body body = createBody(mapObject);
            Coin coin = new Coin(region, body)
            coins.add(coin);
        }
    }

    public void render(SpriteBatch batch){
        for(Coin coin : coins){
            coin.draw(batch);
        }
    }

    public Body createBody(MapObject mapObject){
        // here create body using map object
    }
}

public class Coin extends Sprite {

    private Body body;

    public Coin(TextureRegion region, Body body){
        super(region);
        this.body = body;
    }

    public void update(){
    // here update sprite position using body coordinates
    }
}