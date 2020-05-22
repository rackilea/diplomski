private AudioManager theAudioManager;
private Object myOnAudioFocusChangeListener = null;

private static final int AUDIOMANAGER_AUDIOFOCUS_GAIN = 1;
private static final int AUDIOMANAGER_AUDIOFOCUS_LOSS = -1;

theAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

// instantiating the OnAudioFocusChangeListener by reflection (as it only exists from Android 2.2 onwards)
// we use a Proxy class for implementing the listener
public void setOnAudioFocusChangeListener() {
    Log.i(this, "setOnAudioFocusChangeListener()");
    Class<?>[] innerClasses = theAudioManager.getClass().getDeclaredClasses();
    for (Class<?> interfaze : innerClasses) {
        if (interfaze.getSimpleName().equalsIgnoreCase("OnAudioFocusChangeListener")) {
            Class<?>[] classArray = new Class<?>[1];
            classArray[0] = interfaze;
            myOnAudioFocusChangeListener = Proxy.newProxyInstance(interfaze.getClassLoader(), classArray, new ProxyOnAudioFocusChangeListener());
        }
    }
}

// called by onResume
public void getAudioFocus() {
    if (myOnAudioFocusChangeListener != null) {
        Log.i(this, "getAudioFocus()");
        try {
            Method[] methods = theAudioManager.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equalsIgnoreCase("requestAudioFocus")) {
                    method.invoke(theAudioManager, myOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AUDIOMANAGER_AUDIOFOCUS_GAIN);
                    Log.i(this, "requestAudioFocus");
                }
            }
        } catch (Exception e) {
            Log.e(this, e.getMessage());
        }
    }
}

// called by onPause
public void releaseAudioFocus() {
    if (myOnAudioFocusChangeListener != null) {
        Log.i(this, "releaseAudioFocus()");
        try {
            Method[] methods = theAudioManager.getClass().getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equalsIgnoreCase("abandonAudioFocus"))
                    method.invoke(theAudioManager, myOnAudioFocusChangeListener);
            }
        } catch (Exception e) {
            Log.e(this, e.getMessage());
        }
    }
}