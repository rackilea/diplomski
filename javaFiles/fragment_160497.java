apply plugin: 'java'
defaultTasks 'execute'

repositories {
    mavenCentral()
    maven { url "http://repo.spring.io/libs-milestone" }
}

dependencies {
    compile "org.springframework.boot:spring-boot-starter-data-jpa:1.0.0.RC5"
    compile "org.projectlombok:lombok:1.12.6"
    compile "com.h2database:h2:1.3.175"
}

task execute(type:JavaExec) {
    main = "JpaMultikeyDemo"
    classpath = sourceSets.main.runtimeClasspath
}