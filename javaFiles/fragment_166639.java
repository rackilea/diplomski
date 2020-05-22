Job job = bigquery.jobs().insert(PROJECT_ID, runJob).execute();
String status = job.getStatus().getState();
while(!status.equalsIgnoreCase("DONE")) {
  status = bigquery.jobs().get(PROJECT_ID, job.getId()).execute().getStatus().getState();
  System.out.println("Status: " + status);
  Thread.wait(1000);
}