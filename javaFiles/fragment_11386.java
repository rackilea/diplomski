apply plugin: 'groovy'
dependencies {
    // compile gradleApi()
    compile 'junit:junit:4.11'
}

repositories {
    mavenCentral()
}

task t1 << {
    def manifest = project.file('file.txt')
    manifest.delete()
    manifest << 'Dependencies:\n'

    // you can use it.path here if you need full path to jar
    configurations.runtime.each { manifest << it.name + "\n"}

    // also configurations.compile.each works here
}