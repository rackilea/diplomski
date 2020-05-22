apply plugin: 'java'

sourceCompatibility = 1.5
targetCompatibility = 1.5

version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    compile 'mysql:mysql-connector-java:5.1.34'
    compile 'commons-dbutils:commons-dbutils:1.6'
    compile 'org.apache.commons:commons-csv:1.4'
    compile 'com.itextpdf:itextpdf:5.5.10'
    compile 'net.sf.opencsv:opencsv:2.3'
    testCompile 'junit:junit:4.11'
}

jar {
    archiveName = 'Harmonogramy.jar'

    manifest {
        attributes 'Main-Class': 'Main',
                'Class-Path': configurations.runtime.files.collect { "lib/$it.name" }.join(' '),
                'Implementation-Version': version
    }
    from(configurations.compile.collect { it.isDirectory() ? it : zipTree(it) })
}