ListStepsResult stepsResult = emr.listSteps(new ListStepsRequest().withClusterId(clusterId).withStepIds(req.getStepIds()));
List<StepSummary> stepsList = stepsResult.getSteps();
StepSummary stepSummary = stepsList.get(0);
StepStatus stepSummaryStatus = stepSummary.getStatus();
String stepStatus = stepSummaryStatus.getState();
StepExecutionState stepState = StepExecutionState.valueOf(stepStatus);