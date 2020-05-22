@Configuration
 @PropertySource("classpath:/com/${my.placeholder:default/path}/app.properties")
public class AppConfig {
 @Autowired
 Environment env;

 @Bean
 public TestBean testBean() {
     TestBean testBean = new TestBean();
     testBean.setName(env.getProperty("testbean.name"));
     return testBean;
 }