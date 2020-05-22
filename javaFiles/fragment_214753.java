// single shared timer instance
Timer t = new Timer();

// for each device
Process p = pb.start();
TimerTask killer = new TimeoutProcessKiller(p);
t.schedule(killer, 30000);
// ... read output stream as before ...
int returnVal = p.waitFor();
killer.cancel();