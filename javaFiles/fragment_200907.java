@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ((keyCode == KeyEvent.KEYCODE_BACK)) {
         finish();
    }
    return super.onKeyDown(keyCode, event);
}