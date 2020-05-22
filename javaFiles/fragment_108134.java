@ManagedBean
@ViewScoped
public class Register {

    private Person person;

    @PostConstruct
    public void init() {
        person = Person.create();
    }

    // ...
}