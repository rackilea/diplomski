/**
 * This Async Aspect is used to cleanup the threadScoped beans after an async
 * run. This is required since in spring the async methods run in a pool of
 * thread, so they could share some thread scoped beans.<br>
 * The Thread scope is defined in {@link ThreadScope}
 * 
 * @author enrico.agnoli
 * 
 */
public class AsyncAspect {
    @Autowired
    ThreadScope threadScope;

    private static final Logger log = LoggerFactory
            .getLogger(AsyncAspect.class);

    public void asyncAspectAfter() {
        log.debug("CleanUp of the ThreadScoped beans");
        threadScope.cleanUpThreadScopedBeans();
    }

}