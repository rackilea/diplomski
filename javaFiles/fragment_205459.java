// create IDEA run configurations from Gradle JavaExec tasks
task createRunConfigurations {
    def runConfigurationsDir = new File(".idea/runConfigurations")
    runConfigurationsDir.mkdirs()

    tasks.withType(JavaExec).each { task ->
        def taskName = task.name
        def mainClass = task.main
        def props = task.systemProperties.collect { k, v -> "-D$k=$v" }.join(' ')
        def args = task.args.join(" ")

        def writer = new FileWriter(new File(runConfigurationsDir, "${taskName}.xml"))
        def xml = new MarkupBuilder(writer)

        xml.component(name: "ProjectRunConfigurationManager") {
            configuration(default: 'false', name: taskName, type: "Application", factoryName: "Application", singleton: "true") {
                option(name: 'MAIN_CLASS_NAME', value: mainClass)
                option(name: 'VM_PARAMETERS', value: props)
                option(name: 'PROGRAM_PARAMETERS', value: args)
                option(name: 'WORKING_DIRECTORY', value: 'file://$PROJECT_DIR$')
                module(name: 'module-name')
            }
        }
    }
}