dependencyManagement {
  imports {
    mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
  }
}

dependencies {

  compile group: 'org.thymeleaf.extras', name: 'thymeleaf-extras-springsecurity5'

  compile group: 'org.springframework.boot', name: 'spring-boot-starter-web'
  compile group: 'org.springframework.boot', name: 'spring-boot-starter-actuator'
  compile group: 'org.springframework.boot', name: 'spring-boot-starter-security'

  compile group: 'org.springframework.cloud', name: 'spring-cloud-starter-eureka'
  compile group: 'org.springframework.cloud', name: 'spring-cloud-starter-zipkin'
  compile group: 'org.springframework.cloud', name: 'spring-cloud-starter-config'


  // Swagger for API testing
  compile("io.springfox:springfox-swagger2:${swagger2version}")
  compile("io.springfox:springfox-swagger-ui:${swagger2version}")
  testCompile("org.springframework.security:spring-security-test")
  testCompile group:  'org.springframework.boot', name: 'spring-boot-starter-test'

}