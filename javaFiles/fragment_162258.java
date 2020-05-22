boolean threadStarted = false;

public void onClick(View v) {
    if (!threadStarted) {
        // start thread here
        threadStarted = true;
    } else {
        // Ignore this spurious click
    }
}