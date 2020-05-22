@Override
public boolean dispatchKeyEvent(KeyEvent keyEvent) {

    if (keyEvent.getKeyLocation() == KeyEvent.KEY_LOCATION_NUMPAD) {
         keyEvent.consume();
         return true;
    }
}