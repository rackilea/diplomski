eclipse {
    classpath {
       downloadSources=true
       downloadJavadoc=true
        file {
            withXml {
                def node = it.asNode()
                // find eclipselink javadoc path
                def eclipselinkPath = configurations.compile.find { it.absolutePath.contains('eclipselink') }
                def javaxPersistenceJavadocPath = ""
                node.each {
                    def filePath = it.attribute('path')
                    if (file(filePath) == file(eclipselinkPath)) {
                        javaxPersistenceJavadocPath = it.attributes.attribute.@value[0]
                    }
                }
                // add eclipselink javadoc path as attribute to javax.persistence
                def javaxPersistencePath = configurations.compile.find { it.absolutePath.contains('javax.persistence') }
                node.each {
                    def filePath = it.attribute('path')
                    if (file(filePath) == file(javaxPersistencePath)) {
                        it.appendNode('attributes').appendNode('attribute', [name:'javadoc_location', value:javaxPersistenceJavadocPath])
                    }
                }
            }
        }
    }
}