@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpelTest.Config.class })
public class SpelTest
{
    @Value("#{${my.property}}")
    Product _product;

    @Test
    public void evaluating_spel_from_property_value() throws Exception
    {
        Assert.assertEquals(1234, _product.value);
    }

    @Component
    public static class Factory
    {
        public Product makeVal(int x) { return new Product(x); }
    }

    public static class Product
    {
        public final int value;

        public Product(final int value) { this.value = value; }
    }

    @Configuration
    @ComponentScan(basePackageClasses = SpelTest.class)
    public static class Config
    {
        @Bean
        public Factory factory() { return new Factory(); }

        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
            final PropertySourcesPlaceholderConfigurer psc = new PropertySourcesPlaceholderConfigurer();
            final MutablePropertySources sources = new MutablePropertySources();
            sources.addFirst(new MockPropertySource()
                .withProperty("my.property", 
                          "factory.makeVal(1234)"));
            psc.setPropertySources(sources);
            return psc;
        }
    }
}