buildscript {
    ext {
        springBootVersion = '1.5.8.RELEASE'
    }
    repositories {
        jcenter()
        maven { url 'http://clojars.org/repo' }
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath "com.netflix.nebula:nebula-clojure-plugin:4.4.0"
    }
}


plugins {
    id "nebula.clojure" version "4.4.0"
}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'application'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'


group 'com.demo'
def artifactName = 'demo-service'
version = latestRepoTag()


static def latestRepoTag() {
    def cmd = "git describe --abbrev=0"
    def proc = cmd.execute();
    return proc.text.trim();
}

sourceCompatibility = 1.8
targetCompatibility = 1.8


ext['spring-restdocs.version'] = '1.2.1.RELEASE'
ext {
    springCloudVersion = 'Dalston.SR4'
}

compileJava {
    classpath = project.files(
            project.compileClojure.outputs,
            classpath
    )
}

compileClojure {
    jvmOptions {
        jvmArgs '-Djava.awt.headless=true'
    }
}

repositories {
    jcenter()
    maven { url 'http://clojars.org/repo' }
}

jar {
    baseName = "${artifactName}"
    version = latestRepoTag()
}


clojure.aotCompile = true

configurations{
    dev
}


dependencyManagement {
    imports {
        mavenBom 'org.springframework.cloud:spring-cloud-dependencies:Dalston.SR3'
    }
}


dependencies {

    compile 'org.clojure:clojure:1.6.0'

    compile('com.google.guava:guava:19.0')
    compile("commons-io:commons-io:2.5")
    compile "org.apache.pdfbox:pdfbox:2.0.0-RC3"
    compile("org.apache.commons:commons-lang3:3.0")
    compile("org.springframework.boot:spring-boot-starter-actuator")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.springframework.boot:spring-boot-starter-jdbc")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.cloud:spring-cloud-starter-eureka")

    compileOnly("org.projectlombok:lombok:1.16.6")

    runtime('com.h2database:h2:1.4.190')
    runtime("com.ingres.jdbc:iijdbc:10.0-4.0.5")
    runtime('org.apache.commons:commons-dbcp2:2.1.1')
    runtime('org.postgresql:postgresql:9.4.1209')

    dev("org.springframework.boot:spring-boot-devtools")

    testCompile('com.jayway.jsonpath:json-path')
    testCompile('com.jayway.jsonpath:json-path-assert:2.2.0')
    testCompile('com.google.code.gson:gson:2.8.1')
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("org.springframework.restdocs:spring-restdocs-mockmvc:1.2.1.RELEASE")

}

task wrapper(type: Wrapper) {
    gradleVersion = '4.1'
}

bootRun {
    classpath = sourceSets.main.runtimeClasspath + configurations.dev
    systemProperties = System.properties
    jvmArgs = ["-client", "-Dsun.net.inetaddr.ttl=60", "-Djava.security.egd=file:/dev/./urandom"]
    environment = [
            'spring_profiles_active': 'beta,fast_discovery'
    ]
}