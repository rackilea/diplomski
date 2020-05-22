apply plugin: 'java'

dependencies {
    implementation 'org.apache.commons:commons-io:1.3.2'
    implementation 'org.kie.modules:org-apache-commons-lang3:6.2.0.Beta2'
}

repositories { 
   jcenter()
}

task getDeps(type: Copy) {
    from sourceSets.main.runtimeClasspath
    into 'runtime/'

    doFirst {
        ant.delete(dir: 'runtime')
        ant.mkdir(dir: 'runtime')
    }

    doLast {
        ant.delete(dir: 'runtime')
    }
}