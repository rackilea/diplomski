@Configuration
public class Config {

@Bean
public OkHttpClient okHttpClient() {
    return new OkHttpClient();
    }
 }