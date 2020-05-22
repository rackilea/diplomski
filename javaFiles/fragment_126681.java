public class ExtendedEditText extends EditText {

public ExtendedEditText(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

}

public ExtendedEditText(Context context, AttributeSet attrs) {
    super(context, attrs);

}

public ExtendedEditText(Context context) {
    super(context);

}

@Override
public boolean onKeyPreIme(int keyCode, KeyEvent event) {
    if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
        dispatchKeyEvent(event);
        return false;
    }
    return super.onKeyPreIme(keyCode, event);
}