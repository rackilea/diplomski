private void startMe(int hours) {
  [...]
  try {
    [...]
    ArrayList<Future<String>> futureHoursDone = new ArrayList<>();
    final int numTasks = futureHours.size();
    int done = 0;
    double percentageDone = 0.0d;
    while (futureHours.isEmpty() == false) {
      for (int index = 0; index < futureHours.size(); ++index) {
        Future<String> futureHour = futureHours.get(index);
        if (futureHour.isDone()) {
          futureHours.remove(index);
          futureHoursDone.add(futureHour);
          --index;
          ++done;
          percentageDone = done / (double) numTasks;
        }
      }
    }
  } catch (Exception e) {
    // TODO: don't forget to HCF (https://en.wikipedia.org/wiki/Halt_and_Catch_Fire) :)
    e.printStackTrace();
  }
}