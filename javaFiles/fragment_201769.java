import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;

public class Example implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        Configuration configuration = project.getConfigurations().getByName("compile");
        configuration.forEach(file -> {
            project.getLogger().lifecycle("Found project dependency @ " + file.getAbsolutePath());
        });
    }
}