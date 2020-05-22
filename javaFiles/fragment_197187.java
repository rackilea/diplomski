public class MyPlugin implements Plugin {
    @Override
    public void define(Context context) {
        context.addExtensions(
            MySensor.class, 
            MyPostAnalysisTask.class);
    }
}

public class MySensor implements Sensor {

    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor.name(getClass().getName());
    }

    @Override
    public void execute(SensorContext context) {
        // Get command line param.
        Optional<String> param = context.config().get("my.param.name");
        if (param.isPresent()) {
            context.addContextProperty("my.context.key", param.get());
        }
    }
}

public class MyPostAnalysisTask implements PostProjectAnalysisTask {

    @Override
    public void finished(final ProjectAnalysis analysis) {
        if (analysis.getScannerContext().getProperties().containsKey("my.context.key")) {
            // Perform custom post analysis task.
        }
    }
}