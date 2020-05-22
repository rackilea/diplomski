final long sleepTime = (long) (1000.0 / TARGET_FPS);

System.out.println("Sleep time is " + sleepTime);
long time = System.nanoTime();
long delta = 0;
double cumulativeFpsError = 0.0;
for (int frameCount = 0; true; ++frameCount) {
  Thread.sleep((long) (sleepTime + delta));
  long elapsed = System.nanoTime() - time;
  if (elapsed >= 1_000_000_000) {
    double fps = (double) frameCount / elapsed * 1e9;
    System.out.println(fps);

    cumulativeFpsError += (fps - 60);
    delta += (fps - TARGET_FPS) * 0.55 + 0.14 * cumulativeFpsError;
    frameCount = 0;
    time += elapsed;
  }
}