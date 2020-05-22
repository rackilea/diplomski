while (true)  {
    // Roll dice
    synchronized (turnMonitor)  { turnMonitor.notifyAll(); }
    // Wait for dice to roll
    do  {
        synchronized (controlMonitor)  { controlMonitor.wait(); }
    }  while ( ...not all players have rolled this turn... );
    if ( there's a winner )  break;
}
gameOn = false;