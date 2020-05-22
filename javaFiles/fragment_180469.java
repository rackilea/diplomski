buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'net.sf.proguard:proguard-gradle:6.2.2'
        classpath 'net.sf.proguard:proguard-base:6.2.2'
    }
}

plugins {
    id 'java-library'
    id 'maven-publish'
}

group = 'org.example'
version = '1.0.0'

repositories {
    jcenter()
}

dependencies {
    api 'org.apache.commons:commons-math3:3.6.1'
    implementation 'com.google.guava:guava:23.0'
    testImplementation 'junit:junit:4.12'
}

task createObfuscated(type: proguard.gradle.ProGuardTask, dependsOn: 'jar') {
    description 'Optimizes and obfuscates the created distribution jar.'
    verbose

    injars  "${buildDir}/libs/${project.name}-${version}.jar"
    outjars "${buildDir}/obf/${project.name}-${version}.jar"

    if (System.getProperty('java.version').startsWith('1.')) {
        libraryjars "${System.getProperty('java.home')}/lib/rt.jar"
    } else {
        libraryjars "${System.getProperty('java.home')}/jmods/java.base.jmod", jarfilter: '!**.jar', filter: '!module-info.class'
    }
    libraryjars configurations.findByName('runtimeClasspath').getFiles()

    printmapping 'out.map'

    keep 'public class * { \
        public protected *; \
    }'

    keepclassmembers allowoptimization: true, 'enum * { \
        public static **[] values(); \
        public static ** valueOf(java.lang.String); \
    }'

    keepclassmembers 'class * implements java.io.Serializable { \
        static final long serialVersionUID; \
        static final java.io.ObjectStreamField[] serialPersistentFields; \
        private void writeObject(java.io.ObjectOutputStream); \
        private void readObject(java.io.ObjectInputStream); \
        java.lang.Object writeReplace(); \
        java.lang.Object readResolve(); \
     }'

     overloadaggressively
}

task copyObfuscated(type: Copy, dependsOn: createObfuscated) {
    from "${buildDir}/obf"
    into "${buildDir}/libs"
    include '*.jar'
}

task deleteObfuscated(type: Delete, dependsOn: copyObfuscated) {
    delete '${buildDir}/obf'
}

task proguard dependsOn deleteObfuscated

publishing {
    publications {
        myLibrary(MavenPublication) {
            from components.java
        }
    }

    repositories {
        maven {
            name = 'myRepo'
            url = "file://${buildDir}/repo"
        }
    }
}

publish.dependsOn proguard

wrapper {
    gradleVersion '6.0.1'
}