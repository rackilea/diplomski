@Inject 
JobContext ctx;

List<StepExecution> stepExecs = BatchRuntime.getJobOperator().getStepExecutions(ctx.getInstanceId());

// ... not shown here, but sort through stepExecs and find the one from step1.
StepExecution step2Exec = ... ;  

Serializable userData = step2Exec.getPersistentUserData()