public class MyInputProcessor implements InputProcessor {

    public boolean keyPressed;

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.XXX) {
            keyPressed = true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.XXX) {
            keyPressed = false;
        }

        return false;
    }
}