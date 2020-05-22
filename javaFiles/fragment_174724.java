@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Autowired
    private OrderTypeConvertor orderTypeConvertor;

    ...

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(orderTypeConvertor);
    }
}