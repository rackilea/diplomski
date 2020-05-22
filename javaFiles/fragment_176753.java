import com.install4j.runtime.beans.actions.misc.*;

RunExecutableAction action = new RunExecutableAction();
action.setExecutable(...);
action.setWorkingDirectory(...);
// other configuration
action.execute(context);