long time = System.nanoTime();
for (int frameCount = 0; true; ++frameCount) {
  long end = System.nanoTime() + (long) (1_000_000_000.0 / TARGET_FPS);
  while (System.nanoTime() < end);
  long elapsed = System.nanoTime() - time;
  if (elapsed >= 1_000_000_000) {
    double fps = (double) frameCount / elapsed * 1e9;
    System.out.println(fps);

    frameCount = 0;
    time = System.nanoTime();
  }
}