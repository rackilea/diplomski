private final Vector3 tmpVec3 = new Vector3();

public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    tmpVec3.set(screenX, screenY);
    camera.unproject(tmpVec3);
}