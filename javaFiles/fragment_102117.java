@Bean()
    BatchConfigurer configurer(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new DefaultBatchConfigurer(dataSource) {

            @Autowired(required = false)
            public void setDataSource(@Qualifier("secondaryDataSource") DataSource dataSource) {
                super.setDataSource(dataSource);
            }
        };
    }