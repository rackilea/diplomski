@Stateless
public class SomeService {

    @PostConstruct
    private void constructed() {
        // do post construction job
        // according to the injectionPoint
    }

    @Inject
    private InjectionPoint injectionPoint; // this is possible
}