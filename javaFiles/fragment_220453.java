@Startup
@Singleton
public class HookBean {

    @PreDestroy
    void wholeApplicationShuttingDown {
    }
}