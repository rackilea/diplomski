public class MyCursor {

    private TextureRegion cursor;
    private float x, y;

    public MyCursor(TextureRegion cursorRegion) {
        cursor = cursorRegion;
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.begin();
        spriteBatch.draw(cursor, x, y);
        spriteBatch.end();
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}