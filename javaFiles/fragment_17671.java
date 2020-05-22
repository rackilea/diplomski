@Configuration
public class MyConfiguration {

    @Autowired
    @Qualifier("converters")
    private Collection<Converter> converters;

    @PostConstruct
    public void init() {
        converters.add(xy);
    }

}