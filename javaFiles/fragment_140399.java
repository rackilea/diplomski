@Override
protected void compute() {
  MDC.put("job-id", jobId);
  try {
    /* Do your task */
  } finally {
    MDC.remove("job-id");
  }
}