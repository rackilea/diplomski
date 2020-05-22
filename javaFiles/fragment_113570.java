buildscript {
repositories {
    mavenLocal()
    mavenCentral()
}
dependencies {
    classpath group: 'fr.inria.gforge.spoon',
            name: 'spoon-gradle-plugin',
            version:'1.1'
    classpath group: 'org.eclipse.jdt', name: 'org.eclipse.jdt.core', version: '3.12.2'
}