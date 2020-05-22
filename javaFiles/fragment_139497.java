public static void main(String[] args) {
    long startTime = System.nanoTime();
    long lastFrameTime = startTime;
    long frames = 0;
    int framesToAverage = 10;
    long[] frameTimes = new long[framesToAverage];
    joglplat m = new joglplat();
    while(true){
        // logic here
        long currentFrameDuration = System.nanoTime() - lastFrame;
        lastFrameTime = System.nanoTime();
        long instantFramerate = currentFrameDuration / 1000000;
        int currentFrameIndex = frames % frameTimes.length;
        frameTimes[currentFrameIndex] = currentFrameDuration;
        frames++;
        long averageFramerate = ( ( lastFrameTime - startTime) / frames ) / 1000000;
        long instantFramerate = currentFrameDuration / 1000000;
        if( frames > frameTimes.length ) { // if it isn't, we don't have enough data yet
            int firstFrameIndex = currentFrameIndex + 1;
            if( firstFrameIndex > frameTimes.length ) {
                firstFrameIndex = 0;
            }
            long averageFrameratePerN = ( ( frameTimes[currentFrameIndex] - frameTimes[firstFrameindex] ) / frameTimes.length ) / 1000000;
        }

        // yield/sleep here
    }
}