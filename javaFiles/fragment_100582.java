public void run()  {
    while (gameOn)  {
        synchronized (turnMonitor)  { turnMonitor.wait(); }
        ...roll dice here...
        ...Put sum of Player rolls in volatile instance field or synched field...
        ...Update volatile player turn counter...
        synchronized (controlMonitor)  {
            // Tell control monitor we're done.
            controlMonitor.notifyAll();
        }
    }
}