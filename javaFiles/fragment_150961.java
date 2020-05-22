Long execId = jobCtx.getExecutionId();

List<StepExecution> stepExecs = jobOperator.getStepExecutions(execID);

MyPersistentUserData myData;

for (StepExecution step : stepExecs) {
    if (step.getStepName().equals("somePreviousStepX") {
        myData = (MyPersistentUserData)step.getPersistentUserData();
    }
}

//use myData