@Service
public SomeService {
    @Autowired
    private CacheEnhancedService css;

    public void doSomething() {
        css.getConfig(new File("./file"));
     }
}

@Service
public CacheEnhancedService {
    @Cacheable(value = "configurationCache", key = "#myFile.lastModified()")
    public Object getConfig(File myFile) {
        ...
     }
 }
}