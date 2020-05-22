long currentMillis = System.currentTimeMillis();
if (currentMillis >= this.nextCallMillis) {
    this.nextCallMillis = currentMillis + 86400000/*24 hours*/;
    callEach24hourOneTime();
} else {
    // ...
}