static final IOPool<?> pool;
static {
    final Class<?> clazz = IOPoolLocator.class;
    final Logger logger = Logger.getLogger(clazz.getName(), clazz.getName());
    final ServiceLocator locator = new ServiceLocator(clazz.getClassLoader());
    pool = decorate((IOPool) create(locator, logger), locator, logger);
}