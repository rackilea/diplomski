public class RectActor extends Actor {

    private Texture texture;

    public RectActor(float x, float y, float width, float height, Color color) {
        createTexture((int)width, (int)height, color);

        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
    }

    private void createTexture(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, width, height);
        texture = new Texture(pixmap);  //creating texture for each RectActor is not profitable so create once and share in all RectActor
        pixmap.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
}