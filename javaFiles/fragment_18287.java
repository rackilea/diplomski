import org.jenkinsci.plugins.workflow.job.WorkflowRun
import org.jenkinsci.plugins.workflow.flow.FlowExecution;
import org.jenkinsci.plugins.workflow.graph.FlowGraphWalker;
import org.jenkinsci.plugins.workflow.graph.FlowNode;
import org.jenkinsci.plugins.workflow.graph.StepStartNode;
import org.jenkinsci.plugins.workflow.cps.nodes.StepStartNode;
import org.jenkinsci.plugins.workflow.actions.WorkspaceAction
...
...
b = item.getLastBuild()

if (b instanceof WorkflowRun) {
  exec = b.getExecution();
  if(exec == null)
    continue;
  FlowGraphWalker w = new FlowGraphWalker(exec);
  for (FlowNode n : w) {
    if (n instanceof StepStartNode) {
      action = n.getAction(WorkspaceAction);
      if (action) {
        String node = action.getNode().toString();
        String workspace = action.getPath().toString();
      }
    }
  }
}