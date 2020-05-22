@Bean
  @Scope("prototype")
  public Foo foo(@Autowired Bar bar , DefaultListableBeanFactory beanFactory) {
         //Get all the name of the dependent bean of this bean
         for(String dependentBean : beanFactory.getDependentBeans("foo")){
              //Get the class of each dependent bean
              beanFactory.getType(dependentBean);

         }
        return new Foo(bar);
  }