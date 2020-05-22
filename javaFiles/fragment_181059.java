group 'com.boazj'
version "1.0-SNAPSHOT-${System.currentTimeMillis()}"

apply plugin: 'java'
apply plugin: 'maven'

install.doLast {
        println jar.archiveName
}