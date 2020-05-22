@Component
public class FileLoaderFactory implements ApplicationContextAware {

    // to get new loaders
    private ConfigurableApplicationContext context;

    // to keep already pulled out instances
    private Map<String, FileLoader> loaders;

    public FileLoader getFileLoaderByFileType(String type) {
        // trying to use a lazy-loading mode

        return loaders.get(type) == null ? getFromContext(type) : loaders.get(type);
    }

    private FileLoader getFromContext(String type) {
        // getting a bean from the context, putting it into a map and returning a value

        FileLoader loader = context.getBean(type, FileLoader.class);
        loaders.put(type, loader);
        return loader;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        // a casting here is to get broader functionality from a context instance

        this.context = (ConfigurableApplicationContext) context;
    }

}