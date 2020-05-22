public class MyTextView extends TextView {

public MyTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
}

protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
    if (focused)
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
}

@Override
public void onWindowFocusChanged(boolean focused) {
    if (focused)
        super.onWindowFocusChanged(focused);
}

@Override
public boolean isFocused() {
    //always focus  
    return true;
}
}