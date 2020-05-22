private JobParameters buildJobParameters(String date,String wfId){
   return new JobParametersBuilder().addString("wfId", workflowId).
                        addDate("rundate", runDate);
}

JobParameters jobParameters = buildJobParameters(date,wfId);
JobExecution execution = jobLauncher.run(job,jobParameters);