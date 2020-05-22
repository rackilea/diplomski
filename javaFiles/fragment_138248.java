long currentMillis = System.currentTimeMillis();
if (this.nextCallMillis == 0)
    this.nextCallMillis = currentMillis; // Establish time-of-day
if (currentMillis >= this.nextCallMillis) {
    this.nextCallMillis += ((currentMillis - this.nextCallMillis) / 86400000 + 1) * 86400000;
    callEach24hourOneTime();
} else {
    // ...
}