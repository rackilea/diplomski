private final static Object LOCK = new Object();
private final static Set<Integer> busyRecords = new HashSet<Integer>();

public static void waitToWorkOn(int recordNum) {
   synchronized(LOCK) {
      while (busyRecords.contains(recordNum)) {
         LOCK.wait(); //go to sleep
      }
      busyRecords.add(recordNum); //ours now
   }
}

public static void doneWith(int recordNum) {
   synchronized(LOCK) {
      busyRecords.remove(recordNum);
      LOCK.notifyAll(); //wake sleepers up
   }
}