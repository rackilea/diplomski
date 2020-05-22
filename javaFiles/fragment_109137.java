...
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    compile(
            'org.springframework.social:spring-social-core:1.1.6.RELEASE',
            'org.springframework.social:spring-social-config:1.1.6.RELEASE', 
            'org.springframework.social:spring-social-facebook:2.0.3.RELEASE',
            'org.springframework.social:spring-social-twitter:1.1.0.RELEASE',
            'org.springframework.boot:spring-boot-starter-web',
            'org.springframework.boot:spring-boot-starter-thymeleaf'
    )
}
...