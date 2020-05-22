apply plugin: 'java'
apply plugin: 'idea'

sourceCompatibility = 1.5
version = '1.0'

repositories {
    maven {
        url 'https://maven.atlassian.com/content/repositories/atlassian-public/'
    }
    mavenCentral()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.11'
    compile 'com.google.guava:guava:19.0'
    compile 'com.google.inject:guice-parent:4.0'
    compile 'com.google.inject.extensions:guice-assistedinject:4.0'
    compile 'com.google.inject.extensions:guice-multibindings:4.0'
    compile 'org.apache.commons:commons-lang3:3.4'
    compile 'org.apache.commons:commons-math3:3.6'
    compile 'com.atlassian.jira:jira-rest-java-client-parent:3.0.0'
    compile 'com.atlassian.jira:jira-rest-java-client-core:3.0.0'
    compile 'com.atlassian.jira:jira-rest-java-client-api:3.0.0'
    compile 'com.atlassian.jira:jira-rest-java-client-plugin:3.0.0'
}