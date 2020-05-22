@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ( keyCode == KeyEvent.KEYCODE_MENU ) {
        // do nothing
        return true;
    }
    return super.onKeyDown(keyCode, event);
}