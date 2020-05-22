@Override
public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    if (pointer==forwardPointer) {
        game.forwardButton.isPressed=false;
    }
    if (pointer==leftPointer) {
        game.leftButton.isPressed=false;
    }
    if (pointer==rightPointer) {
        game.rightButton.isPressed=false;
    }}