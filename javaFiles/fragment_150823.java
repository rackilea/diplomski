//Remember to dispose these on application exit.
private Pixmap normalMouseCursor = new Pixmap(Gdx.files.internal("normal-cursor.png"));
private Pixmap transparentMouseCursor = new Pixmap(Gdx.files.internal("transparent-cursor.png"));

/**
 * Set the mouse cursor to either the normal cursor image or a transparent one if hidden.
 *
 * @param shouldHide true if the mouse should be invisble
 */
public void setMouseCursor(boolean shouldHide) {
    if (shouldHide) {
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(transparentMouseCursor, 0, 0));
        Gdx.app.debug(TAG, "Mouse Cursor is invisible");
    } else {
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(normalMouseCursor, 0, 0));
        Gdx.app.debug(TAG, "Mouse Cursor is visible");
    }
}