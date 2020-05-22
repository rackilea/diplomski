MasterClock master = Simulation.instance().getMasterClock();
if (master == null) {
  throw new IllegalStateException("master clock is null");
}
EarthClock earthclock = master.getEarthClock();
if (earthclock == null) {
  throw new IllegalStateException("earthclock is null");
}
t = earthclock.getTimeStamp();