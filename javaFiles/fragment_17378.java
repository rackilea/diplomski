@Bean
    @ConditionalOnMissingBean
    public GridFsTemplate gridFsTemplate(MongoDbFactory mongoDbFactory,
            MongoTemplate mongoTemplate) {
        return new GridFsTemplate(
                new GridFsMongoDbFactory(mongoDbFactory, this.properties),
                mongoTemplate.getConverter());
    }