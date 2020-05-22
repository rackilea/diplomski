implementation("org.springframework.security.oauth:spring-security-oauth2") {
    because "We only want the OAuth2AccessToken interface + implementations without activating Spring Security"
    exclude group: "org.springframework.security", module: "spring-security-web"
    exclude group: "org.springframework.security", module: "spring-security-config"
    exclude group: "org.springframework.security", module: "spring-security-core"
}