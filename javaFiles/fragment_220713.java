private boolean processing = false;
...

int ctr = 0;
// added fix to avoid error on cursor
while(processing) {
    try {
    Log.i(logAppName, "Still processing. Count: " + ctr + ". Is processing? " + processing);
        ctr++;
        Thread.sleep(500);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    if(ctr > 5) {
        break;
    }
}