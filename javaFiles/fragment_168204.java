@Singleton
@Startup
public class StartupBean {
    @PostConstruct
    private void postConstruct() { /* ... */ }

    @PreDestroy
    private void preDestroy() { /* ... */ }
}