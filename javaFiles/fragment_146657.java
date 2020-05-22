public void afterJob(JobExecution jobExecution) {
         int nbItemsProcessed;
         for (StepExecution stepExecution : jobExecution.getStepExecutions()) {
            nbItemsProcessed += stepExecution.getWriteCount();
         }   
      }