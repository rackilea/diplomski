<groovy>
    import groovy.xml.MarkupBuilder

    new File("build/ivy.xml").withWriter { writer ->
        def xml = new MarkupBuilder(writer)
        xml."ivy-module"(version:"2.0") {
            info(organisation:"my.org.name", module:"projects")
            dependencies() {
                new File("/path/to/projects/directory").listFiles().each { dir ->
                    dependency(org:"my.org.name", name:dir.name, rev:"latest.release")
                }
            }
        }
    }
</groovy>