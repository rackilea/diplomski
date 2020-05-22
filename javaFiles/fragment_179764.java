@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProviderTest.MyContext.class})
public class ProviderTest {

    @Autowired
    @Qualifier("bar") // could also be @Resource (without @Autowired)
    private Provider sut;
    @Resource(name="baz")
    private Provider sut2; // could also be @Qualifier(with @Autowired)

    @Test
    public void provide_oneConfig() throws NoSuchFieldException, IllegalAccessException {
        // When
        List<Config> configs = sut.getConfigs();

        // Then
        assertEquals(1, configs.size());
    }

    @Test
    public void provide_twoConfigs() throws NoSuchFieldException, IllegalAccessException {
        // When
        List<Config> configs = sut2.getConfigs();

        // Then
        assertEquals(2, configs.size());
    }

    @Configuration
    public static class MyContext {
        @Bean("bar")
        Provider providerBar() {
            return new Provider"config1.proprietary");
        }
        @Bean("baz")
        Provider providerBaz() {
            return new Provider("config1.proprietary", "config2.proprietary");
        }

        @Bean
        Foo foo() {
            return new Foo(); // this one got mocked in my test
        }
}