public class FolderCondition implements Condition{

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String folderPath = conditionContext.getEnvironment().getProperty("dirPath");
        File folder = new File(folderPath);
        return folder.exists();
    }
}