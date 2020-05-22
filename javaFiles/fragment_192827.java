long currentTime = b.getTime(); // Only call once, to be consistent
long minAbsDiff = Long.MAX_VALUE;
WhateverType minContainer = null;
for (WhateverType x : a) {
    long abs = Math.abs(x.getTime() - currentTime);
    if (abs < minAbsDiff) {
        minAbsDiff = abs;
        minContainer = x;
    }
}