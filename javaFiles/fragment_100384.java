elapsed = System.nanoTime();
if (slow) {
    seconds += ((elapsed -  now) / 1.0E9F) * .5F;
}
else {
    seconds += ((elapsed -  now) / 1.0E9F);
}
now = elapsed;  // so next time you just get the incremental difference