diff.dependsOn compileJava
diffChangeLog.dependsOn compileJava
generateChangelog.dependsOn compileJava

dependencies {
   // as before
   liquibaseRuntime sourceSets.main.output // replaces liquibaseRuntime files('src/main')
}