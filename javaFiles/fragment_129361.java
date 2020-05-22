task("dev") {
    doLast {
        println "executing dev"
        liquibase {
            activities {
                main {
                    changeLogFile changeLog
                    classpath "$projectDir/src/main/resources/"
                    url 'jdbc:postgresql://localhost:5432/project'
                    username 'testName'
                    password 'testPassword'
                    liquibaseSchemaName 'liquibase'
                }
            }
        }
    }
}