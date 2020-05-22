compile("org.springframework.boot:spring-boot-starter-web") {
    exclude module: "spring-boot-starter-logging"
}
compile("org.springframework.boot:spring-boot-starter-actuator") {
    exclude module: "spring-boot-starter-logging"
}

compile('org.slf4j:slf4j-jdk14:1.7.5')
compile('commons-logging:commons-logging:1.1.1')