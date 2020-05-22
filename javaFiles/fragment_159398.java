package task.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class BuildWorkspaceTask extends Task implements IProgressMonitor {

    @Override
    public void execute() throws BuildException {

        IWorkspace workspace = ResourcesPlugin.getWorkspace();

        try {

            // IncrementalProjectBuilder.FULL_BUILD- indicates a full build.
            // IncrementalProjectBuilder.INCREMENTAL_BUILD- indicates a incremental build.
            // IncrementalProjectBuilder.CLEAN_BUILD-

            workspace.build(IncrementalProjectBuilder.CLEAN_BUILD, this);

        } catch (CoreException e) {
            e.printStackTrace();
        }

        super.execute();
    }

    @Override
    public void worked(int arg0) {
        log("worked(" + arg0 + ")");
    }

    @Override
    public void subTask(String arg0) {
        log("subTask(" + arg0 + ")");
    }

    @Override
    public void setTaskName(String arg0) {
        log("setTaskName(" + arg0 + ")");
    }

    @Override
    public void setCanceled(boolean arg0) { }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public void internalWorked(double arg0) {
        log("internalWorked(" + arg0 + ")");
    }

    @Override
    public void done() {
        log("done()");
    }

    @Override
    public void beginTask(String arg0, int arg1) {
        log("beginTask(" + arg0 + ", " + arg1 + ")");
    }

}