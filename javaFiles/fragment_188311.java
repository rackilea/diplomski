private int dragX, dragY;
@Override
public boolean touchDown (int x, int y, int pointer, int button) {
    dragX = x;
    dragY = y;
    return true;
}

@Override
public boolean touchDragged (int x, int y, int pointer) {
    float dX = (float)(x-dragX)/(float)Gdx.graphics.getWidth();
    float dY = (float)(dragY-y)/(float)Gdx.graphics.getHeight();
    dragX = x;
    dragY = y;
    cam.position.add(dX * 10f, dY * 10f, 0f);
    cam.update();
    return true;
}