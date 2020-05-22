@Configuration
@Import(ConfigA.class)
class ConfigB {

    @Autowired ConfigA configA;

    @Bean public Bar bar() {
        return new Bar(configA.fooPrototype());
    }

    @Bean public Buzz buzz() {
        return new Buzz(configA.fooPrototype());
    }
}