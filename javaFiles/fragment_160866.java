public void run() {
    this.runningTime = System.currentTimeMillis();

    // no longer an infinite loop
    while (this.runningTime < this.endTime) {
        this.currentSecond = (int)(this.endTime - this.runningTime) / 1000;
        this.runningTime = System.currentTimeMillis();
    }

    // this code is now reached.
    this.stop();
}