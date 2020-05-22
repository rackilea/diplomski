// now() would be whatever function you use to get the current time (in
// microseconds or milliseconds).
int lastStep = now();
// This would be your main loop.
while (true) {
    int curTime = now();

    // Calculate the time spent since last step.
    int timeSinceLast = curTime - lastStep;

    // Skip logic if no game step is to occur.
    if (timeSinceLast < TIME_PER_STEP) continue;

    // We can't assume that the loop always hits the exact moment when the step
    // should occur. Most likely, it has spent slightly more time, and here we
    // correct that so that the game doesn't shift out of sync.
    // NOTE: You may want to make sure that + is the correct operator here.
    //       I tend to get it wrong when writing from the top of my head :)
    lastStep = curTime + timeSinceLast % TIME_PER_STEP;

    // Move your game forward one step.

}