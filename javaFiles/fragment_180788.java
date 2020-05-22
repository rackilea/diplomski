buildscript {
   ext {
      springBootVersion = '1.5.6.RELEASE'
      gradleVersion = '3.3'
   }

   repositories {
      mavenLocal()
      maven { url "http://cft-nexus.ldn.xxxxxxxxx.com:8081/nexus/content/groups/public/" }
                }
   dependencies {
      classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
                }
            }

        apply plugin: 'application'
        apply plugin: 'java'
        apply plugin: 'eclipse'
        apply plugin: 'idea'
        apply plugin: 'org.springframework.boot'

    version = '0.0.1-SNAPSHOT'
    sourceCompatibility = 1.8

    springBoot{
        buildInfo {
            additionalProperties = [
                    'foo': 'bar'
            ]
        }
    }

  compile "org.springframework.boot:spring-boot-starter-actuator"