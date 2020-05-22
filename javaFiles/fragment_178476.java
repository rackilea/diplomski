@Bean(name = "myVar")
@Lazy
String foo(@Value("${someConfig}") String someConfig) {
    return someConfig;
}

@Component
@Lazy
class SomeComponent {

    @Autowired
    @Qualifier("myVar")
    String myVar;
}