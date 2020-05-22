buildscript {
    ext {
        springBootVersion = "2.2.2.RELEASE"
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath "org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion"
    }
}