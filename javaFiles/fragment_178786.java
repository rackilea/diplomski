public class SqlScriptsCustomTestExecutionListener extends AbstractTestExecutionListener {

    @Override
    public void beforeTestMethod(TestContext testContext) {
        List<Resource> scriptResources = new ArrayList<>();
        Set<Sql> sqlAnnotations = AnnotatedElementUtils.getMergedRepeatableAnnotations(testContext.getTestMethod(), Sql.class);
        for (Sql sqlAnnotation : sqlAnnotations) {
            String[] scripts = sqlAnnotation.scripts();
            scripts = TestContextResourceUtils.convertToClasspathResourcePaths(testContext.getTestClass(), scripts);
            scriptResources.addAll(TestContextResourceUtils.convertToResourceList(testContext.getApplicationContext(), scripts));
        }
        if (!scriptResources.isEmpty()) {

            String debugString = scriptResources.stream().map(r -> {
                try {
                    return r.getFile().getAbsolutePath();
                } catch (IOException e) {
                    System.out.println("Unable to found file resource");
                }
                return null;
            }).collect(Collectors.joining(","));

            System.out.println(String.format("Execute sql script :[%s]", debugString));
        }
    }