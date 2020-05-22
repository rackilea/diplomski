class Example implements Plugin<Project> {
    void apply(Project project) {
        def configuration = project.configurations.getByName('compile')
        configuration.each { File file ->
            println "Found project dependency @ $file.absolutePath"
        }     
    }
}