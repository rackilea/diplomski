FutureTask<List<ConditionFact>> task = getConditionFacts(member);
// wait for the task to complete and get the result:
try {
    List<ConditionFact> conditionFacts = task.get();
}
catch (ExecutionException e) {
    // an exception occurred.
    Throwable cause = e.getCause(); // cause is the original exception thrown by the DAO
}