@Getter
@Setter
@Component
@ConfigurationProperties("application")
public class ApplicationProperties {

    /**
     * The URL to which we should redirect the user once he is logged in the application.
     */
    private String redirectUrl;

}