public class Coin {

    //Fields specific for the coin
    private Vector2 position;
    private int worth;
    private Sprite sprite;

    //Fields for the timer, since this coin dissapears it should hold it's own self destruct timer
    public float timeAlive = 0;
    public float despawnTime = 2;

    public Coin(Vector2 position, int worth, Sprite sprite, float despawnTime) {
        this.position = position;
        this.worth = worth;
        this.sprite = sprite;
        this.despawnTime = despawnTime;
    }

    //Since we hold a list somewhere else of the objects represented by this class we should be able to delete them from the list when the time is up.
    public boolean isAlive()
    {
        return timeAlive < despawnTime;
    }

    //I like to abstract update and draw from render. In update we put the logic, which in this case is updating it's time alive.
    public void update()
    {
        timeAlive += Gdx.graphics.getDeltaTime();
    }

    public void draw(SpriteBatch batch)
    {


        //Draw your object
    }
}

public class SomethingHoldingCoins {

    //A list to hold our coins
    List<Coin> coins = new ArrayList<Coin>();

    //A timer system to spawn coins
    private int spawnTime = 4;
    private int timer = 0;

    public void update()
    {
        //Increment timer by the time since last frame
        timer += Gdx.graphics.getDeltaTime();

        //check if timer past the spawn time
        if (timer >= spawnTime)
        {
            //Add a coin to the list
            coins.add(new Coin(somePosition, 100, coinSprite, 2));
            //subtract spawntime from timer
            timer -= spawnTime;
        }

        //iterate over the list of coins to do stuff like drawing and removing despawned coins

        for (Iterator<Coin> iterator = coins.iterator(); iterator.hasNext())
        {
            Coin coin = iterator.next();
            //Update the coin
            coin.update();
            //Check if it is still alive
            if (!coin.isAlive())
            {
                //remove the coin from the list since it is despawned anyway, then continue with the next iteration
                iterator.remove();
                continue;
            }

            coin.draw(spriteBatch);
        }
    }
}