public class MyServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        // Do something to get the data for your variable
        Object value = ...;

        // Set the variable
        execution.setVariable("VARNAME", value);
    }
}