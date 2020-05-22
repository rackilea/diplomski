apply plugin: 'java'
apply plugin: 'war'

processResources {
    filesMatching('logback.xml') {
        expand(['location':project.property('location')])
    }
}