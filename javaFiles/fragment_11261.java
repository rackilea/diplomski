JShell shell = JShell.builder()
    .executionEngine(new ExecutionControlProvider() {
        @Override
        public String name() {
            return "name";
        }

        @Override
        public ExecutionControl generate(ExecutionEnv ee, Map<String, String> map) throws Throwable {
            return new DirectExecutionControl(new CustomLoaderDelegate());
        }
    }, null)
    .build();
shell.addToClasspath("Example.jar");//Add custom classes to Classpath, otherwise they can not be referenced in the JShell