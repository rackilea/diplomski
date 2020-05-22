class Foobar {
    private ResourceLoader resourceLoader;

    @Autowired
    public Foobar(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    Resource[] loadResources(String pattern) throws IOException {
        return ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(pattern);
    }
}