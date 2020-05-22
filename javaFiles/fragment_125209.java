@Override
public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    if (game.forwardButton.contains(screenX, screenY)) {
        game.forwardButton.isPressed=true;
        forwardPointer=pointer; 
    }
    if (game.leftButton.contains(screenX, screenY)) {
        game.leftButton.isPressed=true;
        leftPointer=pointer;
    }
    if (game.rightButton.contains(screenX, screenY)) {
        game.rightButton.isPressed=true;
        rightPointer=pointer;
    }}