@Configuration
@EnableAutoConfiguration
public class SampleWebStaticApplication implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainerFactory factory) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("html", "text/html;charset=utf-8");
        factory.setMimeMappings(mappings );
    }

    public static void main(String[] args) throws Exception {
    SpringApplication.run(SampleWebStaticApplication.class, args);
    }

}