group 'com.abc.hbasewrapper'
version '1.0-SNAPSHOT'

dependencies {
    compile group: 'org.apache.hbase', name: 'hbase-client', version: '1.3.0'
    compile group: 'org.apache.hbase', name: 'hbase-server', version: '1.2.2'
}

apply plugin: 'java'
apply plugin: 'com.github.johnrengelman.shadow'

shadowJar {
    baseName = 'hbasewrapper'
    version = null
    zip64 true
    relocate ('com.google.protobuf', 'hbasewrapper.com.google.protobuf')
    relocate ('io.netty', 'hbasewrapper.io.netty')
}