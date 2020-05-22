afterEvaluate { project ->

    publishing {
        publications {
            mavenJava(MavenPublication) {
                from components.java
                groupId project.group
                artifactId jar.baseName
                version project.version
            }
        }
    }

}