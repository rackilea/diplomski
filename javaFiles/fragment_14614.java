@Bean
    @Qualifier("complexBeanParam")
    public ComplexBean complexBeanByParameters(List<BasicBean> basicBeans) {
        return new ComplexBean(basicBeans);
    }

    @Bean
    @Qualifier("complexBeanRef")
    public ComplexBean complexBeanByReferences() {
        return new ComplexBean(Arrays.asList(basicBean1(), basicBean2()));
    }