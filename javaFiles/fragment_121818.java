public interface InputHandlerIF {
    void walk(int playerId, Vector2 direction);
    void jump();
    .....
}


class RawInputHandler implements InputProcessor {

    private InputHandlerIF listener;
    private Vector2 direction;
    onKeyDown(int keycode) {
        if(keycode == W) {
            direction = valueToWalkForward;
            listener.walk(playerId, direction);
        }
    }
}