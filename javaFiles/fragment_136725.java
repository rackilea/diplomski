long timeNow = System.currentTimeMillis();
long time = timeNow - timeOfLastProjectile;
if (time < 0 || time > 1000) {
    timeOfLastProjectile = timeNow;
    // Trigger associated action
}