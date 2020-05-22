private static final long MAX_WAIT_FOR_POST = 300000L; // ..ms = 5 minutes.
private long lastPost; // Defaults to 0 anyway.

public void post() {
    lastPost = System.currentTimeMillis();
    // ...
}

public boolean isAllowedToPost() {
    return (lastPost + MAX_WAIT_FOR_POST) < System.currentTimeMillis();
}