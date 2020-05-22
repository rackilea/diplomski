long startTime = System.currentTimeMillis()
for (;;) {
    // do some work
    long elapsed = System.currentTimeMillis() - startTime;
    if (elapsed >= timeOut) {
        break;
    }
}