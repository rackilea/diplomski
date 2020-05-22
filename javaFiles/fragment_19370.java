subprojects {
    // Additional configuration to manipulate the Eclipse classpaths
    configurations {
        parserSubstitution
    }
    dependencies {
        parserSubstitution module("com.example:parser:${project.version}")
    }

    apply plugin: 'eclipse'
    eclipse {
        classpath {
        plusConfigurations += [ configurations.pseLangSubstitution ]
        file {
            whenMerged { cp ->

                // Get Gradle to add the depedency upon
                // parser-xxx.jar via 'plusConfigurations' above.
                // Then this here if we have a dependency on Project(':parser')
                //  - If so, remove it (completing the project -> jar substitution).
                //  - If not, remove the .jar dependency: it wasn't needed.
                def usesParser = entries.removeAll {
                    it instanceof ProjectDependency && it.path.startsWith('/parser')
                }
                def parserJar =
                    cp.entries.find { it instanceof Library && it.path.contains('parser-') }
                if (usesParser) {
                    // This trick stops Buildship deleting it from the runtime classpath
                    parserJar ?. entryAttributes ?. remove("gradle_used_by_scope")
                } else {
                    cp.entries.remove { parserJar }
                }
            }
        }
    }