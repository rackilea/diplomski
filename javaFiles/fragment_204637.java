public void logLargeString(String str) {
    if(str.length() > 3000) {
        Log.i(TAG, str.substring(0, 3000));
        logLargeString(str.substring(3000));
    } else {
        Log.i(TAG, str); // continuation
    }
}