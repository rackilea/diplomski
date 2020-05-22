public class MyInput extends InputAdapter {

    private OrthographicCamera camera;
    private MyCursor myCursor;

    public MyInput(OrthographicCamera camera, MyCursor myCursor) {
        this.camera = camera;
        this.myCursor = myCursor;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        Vector3 temp = camera.unproject(new Vector3(screenX, screenY, 0));
        myCursor.setPosition(temp.x, temp.y);
        return true;
    }
}