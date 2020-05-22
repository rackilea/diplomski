@Override
public void execute(DelegateExecution execution) throws Exception
{
 String workflowInstanceId = ActivitiConstants.ENGINE_ID + "$" + execution.getProcessInstanceId(); 
 //.... rest of the code goes here...
 }