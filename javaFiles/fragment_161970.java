tasks.compileJava {
    doFirst {
        val main by sourceSets
        options.compilerArgs = listOf(
                "--module-path", classpath.asPath,
                "--patch-module", "<module-name>=${main.resources.sourceDirectories.asPath}"
                "--module-version", "${project.version}"
        )
        classpath = files()
    }
}