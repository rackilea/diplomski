@Override
public void onClick(View v) {
    // Preventing multiple clicks, using threshold of 0.5 second
    if (SystemClock.elapsedRealtime() - mLastClickTime < 500) {
        return;
          }
    mLastClickTime = SystemClock.elapsedRealtime();

    ///YOUR BUTTON CLICK HERE
}