Long result = 0L;    
TaskReport[] taskReports = job.getHadoopJob().getTaskReports(TaskType.MAP);
for (TaskReport taskReport : taskReports) {
   try {
       result += taskReport.getTaskCounters().findCounter(TaskCounter.GC_TIME_MILLIS).getValue();
       } catch (Exception ignored) {}
}