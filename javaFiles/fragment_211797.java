private long lastTime = 0;

if(System.currentTimeMillis() >= lastTime + 10000) {
    // Perform action
    lastTime = System.currentTimeMillis();
}