frameTimeMilliseconds = 1000 / frames-per-second

Loop(condition) {
  startFrameTime = system current time in milliseonds
  do frame production
  endFrameTime = system current time in milliseconds
  sleepTime = frameTimeMilliseconds - (endFrameTime - startFrameTime)

  sleep for sleepTime milliseconds
}