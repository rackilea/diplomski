buildscript {
    ext.kotlin_version = '1.3.10'
    ext.junitJupiterVersion  = '5.3.2'

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath 'org.junit.platform:junit-platform-gradle-plugin:1.0.3'
    }
}

plugins {
    id 'java'
    id 'org.jetbrains.kotlin.jvm' version '1.2.51'
}

version '1.0-SNAPSHOT'

sourceCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    testImplementation group: 'junit', name: 'junit', version: '5.3.2'
    // JUnit Jupiter API and TestEngine implementation
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitJupiterVersion}")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:${junitJupiterVersion}")
    testImplementation "org.assertj:assertj-core:3.11.1"
    // To avoid compiler warnings about @API annotations in JUnit code
    testCompileOnly 'org.apiguardian:apiguardian-api:1.0.0'
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    implementation 'com.squareup.retrofit2:adapter-rxjava:2.5.0'
    implementation 'io.reactivex.rxjava2:rxjava:2.2.4'
    implementation 'com.google.firebase:firebase-admin:6.6.0'
    implementation 'com.google.apis:google-api-services-youtube:v3-rev206-1.25.0'
}

compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}
compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}