public class ProcessInstanceSummaryImpl implements ProcessInstanceSummary {

    private String name;
    private Long id;
    private Map<String, Object> processVariables;
    private List<HumanTask> openTasks;
    private List<ProcessInstanceSummaryImpl> subProcesses;
    private Long parentProcessId;

    /*
        No arg constructor here
        Getters and setters here.
    */

}