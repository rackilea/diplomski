allprojects {
    //Put instructions for all projects
    task hello << { task -> println "I'm $task.project.name" }
}

subprojects {
    //Put instructions for each sub project
    apply plugin: "java"
    repositories {
        mavenCentral()
    }



    dependencies {
        testCompile group: 'junit', name: 'junit', version: '4.+'
    }
}