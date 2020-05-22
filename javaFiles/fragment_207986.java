@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {

    if (keyCode == KeyEvent.KEYCODE_BACK) {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            return true;
        }
    }
    return super.onKeyDown(keyCode, event);
}