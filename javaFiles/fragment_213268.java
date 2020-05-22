Pixmap pixmap;

    void getScreenShot(){
        Gdx.gl.glPixelStorei(GL10.GL_PACK_ALIGNMENT, 1);
        pixmap = new Pixmap(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), Pixmap.Format.RGBA8888);
        Gdx.gl.glReadPixels(0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, pixmap.getPixels());
    }

    /**
 * Gets the RGB values of the clicked pixel
 * 
 * @param screenX
 *            X clicked position
 * @param screenY
 *            Y clicked position
 * @return Vector3f of the RGB values.
 */
private Vector3 getRGBValues(int screenX, int screenY) {
    float newY = Gdx.graphics.getHeight() - screenY; //if using y up, you need to convert it to y up from a y down since by default all of the clicked cordinates are in a y down system
    int value = colorMap.getPixel((int) screenX, (int) newY);
    int R = ((value & 0xff000000) >>> 24);
    int G = ((value & 0x00ff0000) >>> 16);
    int B = ((value & 0x0000ff00) >>> 8);

    return new Vector3(R, G, B);
}