private BitmapFont font;
private SpriteBatch batch;

public void create() {        
    batch = new SpriteBatch();    
    font = new BitmapFont();
    font.setColor(Color.BLACK);
}

@Override
public void render() {        
    batch.begin();
    font.draw(batch, String.valueOf(count), 200, 200); //you can change the position as you like
    batch.end();
}