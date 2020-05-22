public class HttpSecurityConfiguration {

public void configureHttpSecurity(@Observes SecurityConfigurationEvent event) {
    SecurityConfigurationBuilder builder = event.getBuilder();

    builder
        .http()
            .forPath("/*.jsf")
                .authenticateWith()
                    .form()
                        .loginPage("/login.jsf")
                        .errorPage("/loginFailed.jsf")
            .forPath("/admin/*")
                .authorizeWith()
                    .role("Administrator");
    }
}