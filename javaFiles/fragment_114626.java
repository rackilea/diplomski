implementation("org.nrg.xnat:web") {
    transitive = false
}
implementation("org.nrg.xnat:xnat-data-models") {
    transitive = false
}
implementation("org.nrg.xdat:core") {
    transitive = false
}
implementation("org.nrg:prefs") {
    transitive = false
}
implementation("org.nrg:framework") {
    transitive = false
}

implementation "org.springframework:spring-web"
implementation "org.springframework.security:spring-security-config"
implementation "org.springframework.security:spring-security-ldap"

implementation "org.apache.commons:commons-lang3"
implementation "org.hibernate.javax.persistence:hibernate-jpa-2.1-api"
implementation "com.google.guava:guava"
implementation "org.slf4j:slf4j-api"
implementation "log4j:log4j"

implementation "org.springframework.security:spring-security-web"
implementation "javax.servlet:javax.servlet-api"

compileOnly "com.google.code.findbugs:jsr305"
compileOnly "org.apache.ivy:ivy:2.4.0"
compileOnly("stratum:stratum") {
    transitive = false
}