SpriteBatch batch;
Sprite sprite;//Main character

@Override
public void create(){        
    batch = new SpriteBatch();
    sprite = new Sprite(new Texture(Gdx.files.internal("data/text.png")));
}

@Override
public void render(){
    //Add logic to control the main character...

    batch.begin();
    sprite.draw(batch);
    batch.end();
}