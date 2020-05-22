public class WithDbService implements DataService {
    private EntityManagerFactory emf;

    public WithDbService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Data getData() {
        ...
    }
}