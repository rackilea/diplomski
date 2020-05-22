public void run() {
    while(!end) {
        // the service may not be the same each time because this function does
        // not directly use the service
        int var = callDynamicService(a,b); 
        // ... do something with the result
        Thread.sleep(SLEEP_TIME);
    }
}

private int callDynamicService(int a, int b) {
    return myService.f(a,b);
}