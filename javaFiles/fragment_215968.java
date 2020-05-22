buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    id 'java'
    id "com.github.spacialcircumstances.gradle-cucumber-reporting" version "0.1.2"
}


group 'org.myorg'
version '1.0-SNAPSHOT'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

project.ext {
    cucumberVersion = '4.0.0'
}


dependencies {
    compile group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '3.5.1'
    testCompile group: 'junit', name: 'junit', version: '4.12'
    testCompile 'io.cucumber:cucumber-java:' + cucumberVersion
    testCompile 'io.cucumber:cucumber-junit:' + cucumberVersion
    testCompile group: 'com.browserstack', name: 'browserstack-local-java', version:'1.0.1'
    testCompile group: 'io.cucumber', name: 'cucumber-picocontainer', version: '2.1.0'
    testCompile group: 'org.hamcrest', name: 'hamcrest-all', version: '1.3'
    testCompile group: 'org.testng', name: 'testng', version: '6.9.10'

}

test {
    systemProperties System.getProperties()
    ignoreFailures = true
    filter
            {
                // Include all tests.
                includeTestsMatching "*.*"
            }

    systemProperty "localBrowser", System.getProperty("localBrowser")
    testLogging.showStandardStreams = true
}

cucumberReports {
    outputDir = file('target/cucumber-report')
    buildId = '0'
    reports = files('target/cucumber-report/json/cucumber-report.json')
}