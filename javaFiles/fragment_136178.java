@Component
public class GroovyFiltersInitializer {

    private Logger logger = LoggerFactory.getLogger(GroovyFiltersInitializer.class);

    @Autowired
    private CustomPathZuulFilterConfig config;

    @PostConstruct
    private void initGroovyFilters() throws Exception {

        List<String> groovyFiltersPath = config.getGroovyFiltersPath();

        if(groovyFiltersPath == null || groovyFiltersPath.size() == 0) {
            return;
        }

        FilterLoader.getInstance().setCompiler(new GroovyCompiler());
        FilterFileManager.setFilenameFilter(new GroovyFileFilter());

        String[] filterDirectoryList = groovyFiltersPath.toArray(new String[0]);
        FilterFileManager.init(5, filterDirectoryList);

        logger.info("Groovy Filter file manager started");
    }
}