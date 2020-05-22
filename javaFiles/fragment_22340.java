@Bean
@Transactional
public ResourceProcessor<Resource> fetchProcessor() {
    return new ResourceProcessor<Resource>() {
        @Autowired
        Neo4jTemplate template;

        @Override
        public Resource process(Resource resource) {
            final Object content = resource.getContent();
            if (content != null) {
                template.fetch(content);
            }
            return resource;
        }
    };
}