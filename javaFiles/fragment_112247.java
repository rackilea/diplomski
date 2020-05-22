@Singleton
public class Dependency {

    @Inject
    Dependency() {
    }

    void check() {
        System.out.print("Instantiated");
    }
}

@Singleton
@Component
public interface ClientComponent {
    void inject(Client client);
}