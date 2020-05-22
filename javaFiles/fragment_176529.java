import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.runtime.ActivityInstance;

public class ExampleExecutionListener implements ExecutionListener {

  public void notify(DelegateExecution execution) throws Exception {
    RuntimeService runtimeService = execution.getProcessEngineServices().getRuntimeService();
    ActivityInstance activityInstance = runtimeService.getActivityInstance(execution.getProcessInstanceId());

    boolean isInAnyUserTask = isInAnyUserTask(activityInstance);
  }

  protected boolean isInAnyUserTask(ActivityInstance activityInstance) {
    if ("userTask".equals(activityInstance.getActivityType())) {
      return true;
    }
    else {
      for (ActivityInstance child : activityInstance.getChildActivityInstances()) {
        boolean isChildInUserTask = isInAnyUserTask(child);
        if (isChildInUserTask) {
          return true;
        }
      }

      return false;
    }
  }
}