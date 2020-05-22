plugins {
    `maven-publish`
    id("org.jetbrains.kotlin.jvm") version "1.3.31"
}

group = "com.company"
version = "1.0.0-SNAPSHOT"

tasks.wrapper {
    gradleVersion = "5.6.1"
    distributionUrl = "https://services.gradle.org/distributions/gradle-$gradleVersion-all.zip"
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

repositories {
    mavenCentral()
}

publishing {
    publications {
        register<MavenPublication>("mavenJava") {
            artifactId = "some-artifactId"
            from(components["java"])
            artifact(sourcesJar.get())
            pom {
                name.set("Project Name")
            }
        }
    }
    repositories {
        maven {
            url = uri("https://company.jfrog.io/company/maven-local")
            credentials {
                username = property("artifactory_user") as String
                password = property("artifactory_password") as String
            }
        }
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    // ...
}