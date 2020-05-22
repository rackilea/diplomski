/**
 * Draws a dotted line between to points (x1,y1) and (x2,y2).
 * @param shapeRenderer
 * @param dotDist (distance between dots)
 * @param x1
 * @param y1
 * @param x2
 * @param y2
 */
private void drawDottedLine(ShapeRenderer shapeRenderer, int dotDist, float x1, float y1, float x2, float y2) {
    shapeRenderer.begin(ShapeType.Point);

    Vector2 vec2 = new Vector2(x2, y2).sub(new Vector2(x1, y1));
    float length = vec2.len();
    for(int i = 0; i < length; i += dotDist) {
        vec2.clamp(length - i, length - i);
        shapeRenderer.point(x1 + vec2.x, y1 + vec2.y, 0);
    }

    shapeRenderer.end();
}