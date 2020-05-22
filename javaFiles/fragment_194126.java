plugins {
    id("org.springframework.boot") version ("1.5.6.RELEASE")
    id("io.spring.dependency-management") version("1.0.6.RELEASE")
    id("nebula.maven-publish")
    java
    …
}
dependencyManagement {
    imports { mavenBom("org.springframework.boot:spring-boot-dependencies:${extra["springBootVersion"]}") }
}