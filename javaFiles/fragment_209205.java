public class MyTask extends DefaultTask {

    @TaskAction
    public void executeTask() {
        project.copy(new Action<CopySpec>() {
            @Override
            void execute(CopySpec copySpec) {
                copySpec.into(libFolder);
                copySpec.from(getProject().getConfigurations().getByName("runtime"));
            }
        });

    }
}