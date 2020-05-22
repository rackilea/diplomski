private class ProxyOnAudioFocusChangeListener implements InvocationHandler {

    // implements the method onAudioFocusChange from the OnAudioFocusChangeListener
    public void onAudioFocusChange(int focusChange) {
        Log.e(this, "onAudioFocusChange() focusChange = " + focusChange);
        if (focusChange == AUDIOMANAGER_AUDIOFOCUS_LOSS) {
            Log.i(this, "AUDIOMANAGER_AUDIOFOCUS_LOSS");
            Message msg = mHandler.obtainMessage(ControllerHandler.SET_ON_PAUSE);
            mHandler.sendMessage(msg);
        } else if (focusChange == AUDIOMANAGER_AUDIOFOCUS_GAIN) {
            Log.i(this, "AUDIOMANAGER_AUDIOFOCUS_GAIN");
            // no action is taken
        }
    }

    // implements the method invoke from the InvocationHandler interface
    // it intercepts the calls to the listener methods
    // in this case it redirects the onAudioFocusChange listener method to the OnAudioFocusChange proxy method
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            if (args != null) {
                if (method.getName().equals("onAudioFocusChange") && args[0] instanceof Integer) {
                    onAudioFocusChange((Integer) args[0]);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        }
        return result;
    }   
}