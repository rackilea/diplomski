private static Map<String, ExecuteWatchdog> watchdogs;
//...
public static String startApplication() {
  //...
  watchdogs.put(id, executor.getWatchdog());
}
public static void stopApplication(String id) {
  watchdogs.get(id).destroyProcess();
  watchdogs.remove(id);
}