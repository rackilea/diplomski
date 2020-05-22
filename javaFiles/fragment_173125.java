@Override
public void draw(Batch batch, float parentAlpha) {
    Color color = getColor();
    batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
    batch.draw(flipped ? front : back, calculateX(logic.column), calculateY(logic.row), getWidth(), getHeight());
}