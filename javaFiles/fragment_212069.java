public abstract class A {
    @Autowired
    protected ARepository aRepository;

    protected void useRepository() {
        aRepository.doSomething();
    }
}

public class B extends A {

    private void useRepositoryAgain() {
        // Fine, since aRepository is protected in the superclass
        aRepository.doSomething();
    }
}