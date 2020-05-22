public class HibernatePersistenceProviderResolver implements PersistenceProviderResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(HibernatePersistenceProviderResolver.class);

    private volatile PersistenceProvider persistenceProvider = new HibernatePersistence();

    public List<PersistenceProvider> getPersistenceProviders() {
    return Collections.singletonList(persistenceProvider);
    }

    public void clearCachedProviders() {
    persistenceProvider = new HibernatePersistence();
    }

    public static void register() {
    LOGGER.info("Registering HibernatePersistenceProviderResolver");
    PersistenceProviderResolverHolder.setPersistenceProviderResolver(new HibernatePersistenceProviderResolver());
    }
}