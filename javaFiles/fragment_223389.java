// 2.0 and above
@Override
public void onBackPressed() {
    moveTaskToBack(true);
}

// Before 2.0
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
        moveTaskToBack(true);
        return true;
    }
    return super.onKeyDown(keyCode, event);
}