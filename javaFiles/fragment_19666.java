...
if (millis == 0 L) {
    while (this.isAlive()) {
        this.wait(0 L);
    }
} else {
    while (this.isAlive()) {
        long delay = millis - now;
        if (delay <= 0 L) {
            break;
        }

        this.wait(delay);
        now = System.currentTimeMillis() - base;
    }
}
...