plugins {
    id 'java'
}
sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

jar {
    manifest {
        attributes 'Main-Class': 'com.oliverlockwood.Main'
    }
}

dependencies {
    compile 'org.apache.httpcomponents:httpclient:4.5.1'
}