camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

if (Gdx.input.justTouched()) {
    if (pointInRectangle(rectangle, touchPoint.x, touchPoint.y)) {
    }
}