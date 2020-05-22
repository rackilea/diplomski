@Startup
@Singleton
public class StartupTask {

    @EJB
    private DatabaseUpdater databaseUpdater;

    @PostConstruct
    void init {
        databaseUpdater.updateDatabase();
    }

}