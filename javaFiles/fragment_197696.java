TaskReport[] maps = jobtracker.getMapTaskReports("your_job_id");
for (TaskReport rpt : maps) {
  long duration = rpt.getFinishTime() - rpt.getStartTime();
  System.out.println("Mapper duration: " + duration);
}
TaskReport[] reduces = jobtracker.getReduceTaskReports("your_job_id");
for (TaskReport rpt : reduces) {
  long duration = rpt.getFinishTime() - rpt.getStartTime();
  System.out.println("Reducer duration: " + duration);
}