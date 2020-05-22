public void draw(ShapeRenderer sRenderer) {

    sRenderer.begin(ShapeType.Filled);
    sRenderer.setColor(1.0f, 0.0f, 0.0f, 0.0f);
    sRenderer.identity();
    sRenderer.translate(1.0f, 1.0f, 0);
    sRenderer.rotate(0.0f, 0.0f, 1.0f, (float) Math.toDegrees(getBody().getAngle()));
    sRenderer.circle(0.0f, 0.0f, 1.0f, 100);
    sRenderer.end();
}