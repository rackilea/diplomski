public void run() {
    while ((this.runningTime = System.currentTimeMillis()) < this.endTime) {
        this.currentSecond = (int)(this.endTime - this.runningTime) / 1000;
    }

    this.stop();
}