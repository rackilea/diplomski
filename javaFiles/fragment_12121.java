public class FooService {
    private Repository repo1;
    private Repository repo2;

    @Transactional(propagation=Propagation.REQUIRES_NEW)
    public void provideService() {
        repo1.retrieveFoo();
        repo2.retrieveFoo();
    }
}