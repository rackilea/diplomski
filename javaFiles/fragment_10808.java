@Scanned
public class YourTask implements CommonTaskType {

    private final CustomVariableContext customVariableContext;

    public YourTask(@ComponentImport CustomVariableContext customVariableContext) {
        this.customVariableContext = customVariableContext;
    }

    @Override
    public TaskResult execute(@NotNull CommonTaskContext taskContext) throws TaskException {
        final TaskResultBuilder taskResultBuilder = TaskResultBuilder.newBuilder(taskContext);
        final BuildLogger buildLogger = taskContext.getBuildLogger();

        Map<String, String> buildVariables = customVariableContext.getVariables(taskContext.getCommonContext());

        // get branch name from build variables
        String branchName = buildVariables.get("planRepository.branchName");

        // log all build variables to console
        buildVariables.forEach((key, value) -> buildLogger.addBuildLogEntry(key + ": " + value));

        return taskResultBuilder.success().build();
    }
}