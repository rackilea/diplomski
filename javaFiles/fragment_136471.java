apply plugin: 'war'
apply plugin: 'java'

description = 'WAR1'
dependencies {
  providedCompile project(':CommonJAR')
    providedCompile group: 'commons-beanutils', name: 'commons-beanutils', version:'1.9.2'
    providedCompile group: 'org.springframework', name: 'spring-jdbc', version:'4.0.5.RELEASE'
    providedCompile group: 'org.springframework', name: 'spring-core', version:'4.0.5.RELEASE'
    providedCompile group: 'org.springframework', name: 'spring-beans', version:'4.0.5.RELEASE'
    providedCompile group: 'org.springframework', name: 'spring-webmvc', version:'4.0.5.RELEASE'
    providedCompile group: 'org.springframework', name: 'spring-oxm', version:'4.0.5.RELEASE'
    providedCompile group: 'org.springframework', name: 'spring-orm', version:'4.0.5.RELEASE'
    providedCompile group: 'org.springframework', name: 'spring-context-support', version:'4.0.5.RELEASE'
    providedCompile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version:'2.2.3'
    providedCompile group: 'org.json', name: 'json', version:'20090211'
    providedCompile(group: 'org.springframework', name: 'spring-context', version:'4.0.5.RELEASE') {
exclude(module: 'commons-logging')
    }
    providedCompile group: 'commons-logging', name: 'commons-logging', version: '1.2'
    providedCompile group: 'org.aspectj', name: 'aspectjrt', version:'1.7.4'
    providedCompile group: 'org.slf4j', name: 'slf4j-api', version:'1.7.5'
    compile(group: 'log4j', name: 'log4j', version:'1.2.15') {
exclude(module: 'jms')
exclude(module: 'jmxtools')
exclude(module: 'jmxri')
    }
    providedCompile group: 'javax.inject', name: 'javax.inject', version:'1'
    providedCompile group: 'javax.servlet', name: 'jstl', version:'1.2'
    providedCompile group: 'io.springfox', name: 'springfox-swagger2', version:'2.1.1'
    providedCompile group: 'org.springframework', name: 'spring-web', version:'4.0.5.RELEASE'
    providedCompile group: 'org.slf4j', name: 'jcl-over-slf4j', version:'1.7.5'
    providedCompile group: 'org.slf4j', name: 'slf4j-log4j12', version:'1.7.5'
    providedCompile group: 'javax.servlet', name: 'servlet-api', version:'2.5'
    providedCompile group: 'javax.servlet.jsp', name: 'jsp-api', version:'2.1'
    providedCompile group: 'org.apache.axis', name: 'axis', version:'1.4'
}


war{
  manifest {
      attributes(
         "Manifest-Version": "1.0",
         "Class-Path": configurations.providedCompile.collect {" lib/" + it.getName() }.join(' ')
      )
   }

}