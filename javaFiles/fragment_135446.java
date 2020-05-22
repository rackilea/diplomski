@Component
    public class ServiceASecurityConfig implements HttpSecurityConfig {
        @Override
        public Consumer<ServerHttpSecurity> configuration() {
            return (http) -> {

                http.authorizeExchange()
                        .pathMatchers(HttpMethod.GET, "/api/serviceA/**")
                        .hasAuthority("PROP_A");
            };
        }
    }

    @Component
    public class ServiceBSecurityConfig implements HttpSecurityConfig {
        @Override
        public Consumer<ServerHttpSecurity> configuration() {
            return (http) -> {

                http.authorizeExchange()
                        .pathMatchers(HttpMethod.GET, "/api/serviceB/**")
                        .hasAuthority("PROP_B");
            };
        }
    }