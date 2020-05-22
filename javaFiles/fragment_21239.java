@EnableOAuth2Client
@EnableResourceServer
@SpringBootApplication
public class HelloOauthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloOauthServiceApplication.class, args);
    }

    @Bean
    public OAuth2RestTemplate oAuth2RestTemplate(OAuth2ProtectedResourceDetails resource){
        return new OAuth2RestTemplate(resource);
    }
}