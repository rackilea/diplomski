@Autowired PropertySourcesPlaceholderConfigurer property;


@Autowired OctopusPropertiesRepository repo;


   @PostConstruct
    public  void onInit() {

        Map<String,Object> props = new ConcurrentHashMap<>();
        List<OctopusProperties> loadedSettings = repo.findAll();
        loadedSettings.forEach(entry -> props.put(entry.getKey(), entry.getValue()));
        MutablePropertySources mutablePropertySources = new MutablePropertySources();
        mutablePropertySources.addFirst(new MapPropertySource("custom", props));
        property.setPropertySources(mutablePropertySources);

    }