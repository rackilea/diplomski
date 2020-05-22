long currentTime = b.getTime(); // Only call once, to be consistent
long minAbsDiff = Long.MAX_VALUE;
int minIndex = -1;
for(int i=0; i < a.length; i++) {
    diff[i] = a[i].getTime() - currentTime;
    long abs = Math.abs(diff[i]);
    if (abs < minAbsDiff) {
        minAbsDiff = abs;
        minIndex = i;
    }
}