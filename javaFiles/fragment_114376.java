OnKeyPreImeListener onKeyPreImeListener;

public void setOnKeyPreImeListener(OnKeyPreImeListener onKeyPreImeListener) {
    this.onKeyPreImeListener = onKeyPreImeListener;
}

@Override
public boolean onKeyPreIme(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
        if(onKeyPreImeListener != null)
            onKeyPreImeListener.onBackPressed();
        Log.d(TAG, "HIDING KEYBOARD");
        return false;
    }
    return super.dispatchKeyEvent(event);
}

public interface OnKeyPreImeListener {
    void onBackPressed();
}