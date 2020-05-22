@Component
public class Application {
    private final A a;

    @Inject
    public Application(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }
}

@Configuration
@ComponentScan({"me.derekmahar.atinject.application", "me.derekmahar.atinject.model"})
public class ApplicationConfiguration {
    @Bean
    public A getA() {
        return new A("A1");
    }
}