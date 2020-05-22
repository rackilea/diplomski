apply plugin: 'java'
apply plugin: 'eclipse-wtp'  // The correct plug-in!
apply plugin: 'application'
apply plugin: 'war'

sourceCompatibility = 1.7
targetCompatibility = 1.7

tasks.withType(JavaCompile) {
    options.encoding = "UTF-8"
}

def hibernateVersion = "4.3.7.Final"
def weldVersion = "1.1.27.Final"//"2.2.7.Final" Demoiselle 2.4.1 não é compatível com Weld 2
def demoiselleVersion = "2.4.1"
def arquillianVersion = "1.1.5.Final"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    runtime 'javax.servlet:javax.servlet-api:3.1.0'
    runtime 'javax.enterprise:cdi-api:1.0-SP1'
    runtime 'org.jboss:jandex:1.2.2.Final'
}

eclipse {
    wtp {
        facet {
            facet name: "java", version: "1.7"          // Java version
            facet name: "jst.web", version: "3.0"       // Dynamic Web Application
            facet name: "jst.jsf", version: "2.2"       // Java Server Faces
            facet name: "wst.jsdt.web", version: "1.0"  // JavaScript
        }
    }
}

task wrapper(type: Wrapper) {
    gradleVersion = '2.2.1'
}