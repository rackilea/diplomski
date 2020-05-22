ext['jetty.version'] = '8.1.22.v20160922'

dependencies {
    compile group: 'org.codehaus.groovy', name: 'groovy-all', version: '2.4.12'
    compile 'org.springframework.boot:spring-boot-starter-web', {
        exclude module: 'spring-boot-starter-tomcat'
        exclude group: 'com.fasterxml.jackson.core'
    }

    compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.7.9' // last version for Java 6
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-annotations', version: '2.7.9'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.7.9.1'

    providedCompile 'javax.servlet:javax.servlet-api:3.0.1'

    providedRuntime 'org.springframework.boot:spring-boot-starter-jetty', {
        exclude group: 'org.eclipse.jetty.websocket'
    }
}