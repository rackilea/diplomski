group 'TGAdminsBot'
version '0.1'

apply plugin: 'java'
apply plugin: 'idea'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
}
idea {
    module
            {
                downloadJavadoc = true
                downloadSources = true
            }

}
configurations {
    quasar
}

dependencies {
    compile 'co.paralleluniverse:quasar-core:0.7.4:jdk8'
    quasar 'co.paralleluniverse:quasar-core:0.7.4:jdk8'
    compile 'com.fasterxml.jackson.core:jackson-databind:2.7.4'
    compile 'com.fasterxml.jackson.core:jackson-core:2.7.4'
    compile 'co.paralleluniverse:comsat-httpclient:0.7.0'
    compile group: 'com.squareup.okhttp3', name: 'okhttp', version: '3.2.0'
    testCompile group: 'junit', name: 'junit', version: '4.11'

}


tasks.withType(JavaExec)
        {
            jvmArgs "-javaagent:${configurations.quasar.iterator().next()}"
        }
task run(type: JavaExec) {

    main = 'com.sunova.bot.Launcher'
    classpath = sourceSets.main.runtimeClasspath
}