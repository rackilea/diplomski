@Configuration
@ComponentScan("com.project")
public class ResponseConfig {

    @Bean
    public ResponseTypeService protectionResponse() throws Exception{
        return new ProtectionTypeResponse();
    }

    @Bean
    @Qualifier("fileUInit")
    public String fileUInit() {
        return "whatever";
    }
}