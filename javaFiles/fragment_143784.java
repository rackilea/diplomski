class Config {
    @Bean
    public static GenericBeanGenerator<GenericService, Class<?>> genericServiceGenerator() {
        List<Class<?>> entities = Arrays.asList(A.class, B.class);

        return new GenericBeanGenerator<GenericService, Class<?>>(GenericService.class, entities) {
            @Override
            public String getBeanName(Class<?> generic) {
                return generic.getSimpleName() + "Service";
            }

            @Override
            public void initiliaze(String beanName, Class<?> generic, GenericService instance) {
                instance.setEntityClass(generic);
            }
        };
    }
}