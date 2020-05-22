Stream in;
long timestamp = System.currentTimeInMillis();
int counter = 0;
int INTERVAL = 1000; // one second
int LIMIT = 1000; // bytes per INTERVAL

...

/**
 * Read one byte with rate limiting
 */
@Override
public int read() {
    if (counter > LIMIT) {
        long now = System.currentTimeInMillis();
        if (timestamp + INTERVAL >= now) {
            Thread.sleep(timestamp + INTERVAL - now);  
        }
        timestamp = now;
        counter = 0;
    }
    int res = in.read();
    if (res >= 0) {
        counter++;
    }
    return res;
}