private class BackgroundCalc extends Thread
  {
    public void run()
    {
      /*
      initializing stuff here
      */
      for (int x = 0; x < daysBetween; x++)
      {
        progress = (100 * (x + 1)) / daysBetween;
        if (destroyCalcThread) return;
        /*
        background calculations here
        */
      }
      /*
      finish up thread here
      */
    }
  }