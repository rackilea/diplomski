ThreadInfo[] threadInfos = ....;
Set<Long> tIds = new HashSet<>();
for (ThreadInfo tIndo : threadInfos) {
  tIds.add(tIndo.getId());
}
for (Thread t : Thread.getAllStackTraces().keySet()) {
  if(tIds.contains(t.getId()) {
    t.interrupt();
  }
}