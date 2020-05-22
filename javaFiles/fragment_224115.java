public RepeatStatus execute(StepContribution contribution,
        ChunkContext chunkContext) throws Exception {

//Retrieving value from Execution context
(ArrayList) chunkContext.getStepContext()
            .getStepExecution().getJobExecution().getExecutionContext()
            .get(Constants.DATA_LIST);

 }