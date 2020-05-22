private void disableConnectionReuseIfNecessary() {
    // HTTP connection reuse which was buggy pre-froyo
    if (Integer.parseInt(Build.VERSION.SDK) <= Build.VERSION_CODES.FROYO) {
        System.setProperty("http.keepAlive", "false");
    }
}