@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.x.apimanager")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.x.apimanager.repository")
@EnableScheduling
public class WebAppConfig {