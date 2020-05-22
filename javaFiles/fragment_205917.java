apply plugin: 'java'
apply plugin: 'maven'
apply plugin: 'application'

targetCompatibility = 1.8
sourceCompatibility = 1.8
version = '0.0.1-SNAPSHOT'
group = 'com.s2d'
mainClassName = 'com.simonsoftwaredesign.example.echo.server.EchoServerApp'

repositories {
  mavenCentral()
}

configurations {
  webContainer
}

dependencies {
  compile project(':echo-core')
  compile group: 'org.eclipse.jetty', name: 'jetty-server', version: '9.3.7.v20160115'
  compile group: 'org.eclipse.jetty', name: 'jetty-webapp', version: '9.3.7.v20160115'

  webContainer project(path: ':echo-admin', configuration: 'warApp')
}

task copyWebApps(dependsOn: configurations.webContainer, type: Copy) {
  from { configurations.webContainer.collect { it } }
  // I don't like how this is hard coded
  // but I am not sure how to fix it
  into 'src/main/dist/webapp'
}

installDist.dependsOn copyWebApps
distZip.dependsOn copyWebApps
distTar.dependsOn copyWebApps