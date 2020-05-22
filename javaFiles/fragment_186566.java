public class TestActor extends Widget {
Texture texture;
Sprite sprite;

public TestActor(){
    // I used the default generated image badlogic.jpg
    texture = new Texture(Gdx.files.internal("badlogic.jpg"));
    sprite = new Sprite(texture);
}

@Override
public void draw(Batch batch, float parentAlpha){

    Color color = getColor();
    batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);

    batch.draw(sprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
}