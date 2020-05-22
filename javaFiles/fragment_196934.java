import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
import org.apache.tools.ant.taskdefs.Copy;

public class MyCopyTask extends Copy {
    public MyCopyTask() {
        setProject(new Project());
        getProject().init();
        setTaskName("MyCopy");
        setTaskType("MyCopy");
        setOwningTarget(new Target());
    }
}