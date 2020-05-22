double testEnd;
double testStart;
testStart = System.nanoTime();
for (int i = 0; i<1000000; i++) {doStuff()}
testEnd = System.nanoTime();
Log.v("speed test", "it takes "+ (testEnd - testStart)/1000000 + " nanoseconds");