@SpringApplicationConfiguration(classes = TestClass.TestConfiguration.class)
public class TestClass extends AbstractTest {

    @Configuration
    @Import( TestConfig.class )
    public static class TestConfiguration {
       //...
    }
}

@Configuration
@EnableAutoConfiguration(exclude = { EmbeddedMongoAutoConfiguration.class })
// @ComponentScan(value = { "package1", "package2" }) // GET RID OF THIS
@Import( { TestMongoConfiguration.class /*, OtherConfig.class, ... */ } )
public class TestConfig {

}