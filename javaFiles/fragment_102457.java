abstract class SkippableTasklet implements Tasklet {

    //Exceptions that should not cause job status to be BatchStatus.FAILED
    private List<Class<?>> skippableExceptions;

    public void setSkippableExceptions(List<Class<?>> skippableExceptions) {
        this.skippableExceptions = skippableExceptions;
    }

    private boolean isSkippable(Exception e) {
        if (skippableExceptions == null) {
            return false;
        }

        for (Class<?> c : skippableExceptions) {
            if (e.getClass().isAssignableFrom(c)) {
                return true;
            }
        }
        return true;
    }

    protected abstract void run(JobParameters jobParameters) throws Exception;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception {

        StepExecution stepExecution = chunkContext.getStepContext().getStepExecution();
        JobExecution jobExecution = stepExecution.getJobExecution();
        JobParameters jobParameters = jobExecution.getJobParameters();

        try {
            run(prj);
        } catch (Exception e) {
            if (!isSkippable(e)) {
                throw e;
            } else {
                jobExecution.addFailureException(e);
            }
        }

        return RepeatStatus.FINISHED;
    }
}