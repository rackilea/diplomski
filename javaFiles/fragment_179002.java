//a the start of rendering process
long startRendering=System.nanoTime();

... rendering here...

//duration of the frame rendering in ms :
long durationMs=TimeUnit.NANOSECONDS.toMillis(System.nanoTime()-startRendering);

// now waits 
if (durationMs < fps) 
{
renderingThread.sleep(fps - durationMs);
}