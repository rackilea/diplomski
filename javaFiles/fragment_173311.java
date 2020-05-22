task createPom() {
    pom {
        project {
            groupId 'Foo'
            artifactId 'Bar'
            version '1.0'
        }.withXml { 
            asNode().appendNode('packaging', 'jar')
        }
    }.writeTo("build/libs/pom.xml")
}