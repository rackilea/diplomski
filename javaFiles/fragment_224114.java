public RepeatStatus execute(StepContribution stepContribution,
        ChunkContext chunkContext) throws Exception {

//Putting value in Execution Context
chunkContext.getStepContext().getStepExecution().getJobExecution()
            .getExecutionContext()
            .put(Constants.DATA_LIST, idList);