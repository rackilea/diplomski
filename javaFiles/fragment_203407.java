@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK)) {
        Log.d(this.getClass().getName(), "back button pressed");
    }
    return super.onKeyDown(keyCode, event);
}