long lastSize = 
int maxSleep = 5000, sleep = 200;
while(!Thread.currentThread().isInterrupted()) {
     long size = file.length();
     if (size > lastSize) {
        copyData(size - lastSize);
        lastSize = size;
        sleep = 200;
     } else {
        Thread.sleep(sleep);
        sleep += 200;
        if (sleep > maxSleep)
            sleep = maxSleep;
}