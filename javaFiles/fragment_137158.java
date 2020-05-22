apply plugin: 'java'

repositories {
    mavenCentral()
}

dependencies {
    compile 'com.google.oauth-client:google-oauth-client-java6:1.20.0'
    compile 'com.google.apis:google-api-services-cloudtrace:v1-rev6-1.22.0'
}

jar {
    from configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
}