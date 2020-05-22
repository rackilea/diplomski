import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.apache.tools.ant.types.Path;

public class Test {
    public static void main(String[] args) throws Exception {    
        Project project = new Project();
        File buildFile = new File("build.xml");
        project.init();
        ProjectHelper.configureProject(project, buildFile);

        Path path = (Path) project.getReference("classpath");
     }
}