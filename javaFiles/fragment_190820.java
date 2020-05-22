@Override
public boolean onKeyPreIme(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
        this.clearFocus();
        //Fix- Ui Flicker
       //  this.setFocusable(false);
       // this.setFocusableInTouchMode(false);          
        return false;
    }
    return super.dispatchKeyEvent(event);
}