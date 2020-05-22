public void run() {
    while(!end) {
        //while this function is running, myService will not change
        int var = myService.f(a,b); 
        // ... do something with the result
        Thread.sleep(SLEEP_TIME);
    }
}