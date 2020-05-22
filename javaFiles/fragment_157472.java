apply plugin: 'java'
apply plugin: 'application'

mainClassName = 'org.myapp.Main'

repositories { jcenter() }
dependencies {
    compile 'org.slf4j:slf4j-api:1.7.13'
    compile 'org.apache.commons:commons-math3:3.6'

    testCompile 'junit:junit:4.12'
}