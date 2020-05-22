plugins {
    application
}

group = "..."
version = "..."

java {
    sourceCompatibility = JavaVersion.VERSION_13
}

application {
    mainClassName = "<module-name>/<mainclass-name>"
}

tasks {
    compileJava {
        doFirst {
            options.compilerArgs = listOf(
                    "--module-path", classpath.asPath,
                    "--module-version", "${project.version}"
            )
            classpath = files()
        }
    }

    named<JavaExec>("run") {
        doFirst {
            val main by sourceSets
            jvmArgs = listOf(
                    "--module-path", classpath.asPath,
                    "--patch-module", "<module-name>=${main.output.resourcesDir}",
                    "--module", application.mainClassName
            )
            classpath = files()
        }
    }
}