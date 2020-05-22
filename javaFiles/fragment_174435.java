ext {
    springCloudVersion = 'Edgware.SR3' // Ties in with the dependencyManagement block below
}

dependencies {
    compile('org.springframework.boot:spring-boot-starter-security') //added dependency
    compile('org.springframework.cloud:spring-cloud-starter-oauth2') //added dependency
    compile('org.springframework.cloud:spring-cloud-starter-security') //added dependency
    compile('org.springframework.boot:spring-boot-starter-data-jpa')
    compile('org.springframework.boot:spring-boot-starter-web')
    compile('org.springframework.boot:spring-boot-starter-thymeleaf')
    compile('org.springframework.data:spring-data-rest-hal-browser')
    runtime('org.springframework.boot:spring-boot-devtools')
    runtime('org.postgresql:postgresql')
    testRuntime('com.h2database:h2')
    testCompile('org.springframework.boot:spring-boot-starter-test')
    testCompile('org.springframework.security:spring-security-test') //added dependency
}

// for finding dependencies
dependencyManagement {
    imports {
        mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
    }
}