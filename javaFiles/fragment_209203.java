class MyCustomPlugin extends Plugin<Project> {

    void apply(Project project) {
        project.tasks.create("copyDeps", Copy.class) {
            from configurations.runtime
            into 'build/lib'
        }
    }

}