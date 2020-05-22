class YourCustomJavaPlugin implements Plugin<Project> {
    void apply(Project project){
        // 1st apply the 'java-base' plugin
        project.apply(plugin:'java-base')

        // 2nd apply your own conventions on top
        project.sourceSets.create("customSourceSet")
        Zip myZip = project.tasks.create("zip", Zip)
        ...
    }
}