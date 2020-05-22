buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:1.1.0'
    }
}
dependencies {
    testCompile 'junit:junit:4.12'
    testCompile 'org.hamcrest:hamcrest-core:1.1'
    testCompile 'org.hamcrest:hamcrest-library:1.1'
    testCompile 'org.hamcrest:hamcrest-integration:1.1'
    testCompile('org.robolectric:robolectric:2.4') {
        exclude module: 'classworlds'
        exclude module: 'commons-logging'
        exclude module: 'httpclient'
        exclude module: 'maven-artifact'
        exclude module: 'maven-artifact-manager'
        exclude module: 'maven-error-diagnostics'
        exclude module: 'maven-model'
        exclude module: 'maven-project'
        exclude module: 'maven-settings'
        exclude module: 'plexus-container-default'
        exclude module: 'plexus-interpolation'
        exclude module: 'plexus-utils'
        exclude module: 'wagon-file'
        exclude module: 'wagon-http-lightweight'
        exclude module: 'wagon-provider-api'
    }
}