while (!isStopped)
{
  while (hasWork() && !isPaused && !isStopped)
  {
      // do work
  }
  if (!isStopped)
  {
     // either just sleep for a few milliseconds (easy way) or wait()
  }
}