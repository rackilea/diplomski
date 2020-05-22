@Startup
@Singleton
public class StartUp {

@PostConstruct
public void addSfaApi() {
    TimerHelper timer = new TimerHelper(new SfaAPI());
}

class SfaAPI implements Callable<Void> {

    @Override
    public Void call() throws ResourceRepositoryException {
        addSomethingToDatabase();
        return null;
    }
  }
}