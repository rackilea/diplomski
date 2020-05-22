@Import({SecurityConfig.class/*,and other config classes*/})
@EnableWebMvc
@Configuration
@ComponentScan({"com.myapp.service.config",
"com.myapp.webapp"
} )

public class WebConfig implements WebMvcConfigurer {
//other bean stuff
}