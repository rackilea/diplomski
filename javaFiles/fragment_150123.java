// Swap the order of the JRE and classpathcontainer
// https://issuetracker.springsource.com/browse/STS-4332
task afterEclipseImport(description: "Post processing after project generation", group: "IDE") {
    doLast {
        def cp = new XmlParser().parse(file(".classpath"))
        def container
        def cons = cp.classpathentry.findAll { it.@kind == "con" }
        cons.find {
            if (it.@path.equals("org.springsource.ide.eclipse.gradle.classpathcontainer")) {
                println "found Gradle dependency container"
                container = it
            } else if (it.@path.contains("JRE_CONTAINER")) {
                if (container == null) {
                    println "found JRE container before Gradle dependency container, nothing to do"
                    // Return true to end the loop (return by itself is not enough)
                    return true
                }
                println "found JRE container, swap with Gradle dependency container"
                container.replaceNode(it)
                it.replaceNode(container)
                // Return true to end the loop (return by itself is not enough)
                return true
            }
            return false
        }
        def builder = new StreamingMarkupBuilder()
        builder.encoding = "UTF-8"
        file(".classpath").withWriter {writer ->
             writer << builder.bind { mkp.xmlDeclaration() }
             def printer = new XmlNodePrinter(new PrintWriter(writer))
             // println cp
             printer.print(cp)
        }
    }
}