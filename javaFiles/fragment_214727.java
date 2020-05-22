public class CustomSpinner extends Spinner {

    ... Constructors ...

    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        Log.d(CustomSpinner.class.getSimpleName(), "onWindowFocusChanged: " + hasWindowFocus);
        if (hasWindowFocus) {
            // User click out of window
        } else {
            // User click in spinner window
        }
    }
}