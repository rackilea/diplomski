@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = {TestConfig.class, ApplicationConfig.class})
public class ApplicatonTest {
    @Profile("test")
    @Configuration
    static class TestConfig {

        @Bean
        @Primary
        public SomeBean testBeanDefinition() {
            SomeBean testBean = new SomeBean();
            // configure SomeBean for test
            return testBean;
        }
    }
    // tests
}