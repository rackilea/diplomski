private static final long DOUBLE_PRESS_INTERVAL = /* some value in ns. */;
private long lastPressTime;

@Override
public void onBackPressed() {
    long pressTime = System.nanoTime();
    if(pressTime - lastPressTime <= DOUBLE_PRESS_INTERVAL) {
        // this is a double click event
    }
    lastPressTime = pressTime;
}