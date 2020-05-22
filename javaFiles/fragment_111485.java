@Override
public boolean dispatchKeyEvent(KeyEvent event) {
    InputDeviceState state = getInputDeviceState(event);
    if (state != null) {
        switch (event.getAction()) {
            case KeyEvent.ACTION_DOWN:
                if (state.onKeyDown(event)) {
                    //Do my thing
                }
                break;
            case KeyEvent.ACTION_UP:
                if (state.onKeyUp(event)) {
                    //Do my thing
                }
                break;
        }
        return true;
    }
    return super.dispatchKeyEvent(event);
}