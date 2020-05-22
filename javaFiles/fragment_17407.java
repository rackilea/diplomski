@Provider
public class MoxyConfigResolver implements ContextResolver<MoxyJsonConfig> {

    private final MoxyJsonConfig config;

    public MoxyConfigResolver() {
        config = new MoxyJsonConfig();
        config.setIncludeRoot(true);
    }

    @Override
    public MoxyJsonConfig getContext(Class<?> type) {
        return config;
    } 
}