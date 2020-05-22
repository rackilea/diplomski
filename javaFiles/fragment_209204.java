public class MyTask extends DefaultTask {

    @TaskAction
    public void executeTask() {
        project.copy {
            into(libFolder)
            from(project.configurations.runtime)
        }
    }
}