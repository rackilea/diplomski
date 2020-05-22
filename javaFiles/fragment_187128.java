interface IWorkflow<T extends IWorkflowStartArgs>
{
    public void start(T args);
    public void doWork();
    public void end();
}