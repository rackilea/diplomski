@Bean
Keycloak initKeycloakWithAdminRole() {
    return Keycloak.getInstance(
            "http://localhost:8080/auth",
            "master",
            "admin",
            "admin",
            "admin-cli");