public class MyInterfaceScanRegistrar implements ImportBeanDefinitionRegistrar, EnvironmentAware {
  private Environment environment;

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
  }

  @Override
  public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
    // Get the MyInterfaceScan annotation attributes
    Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(MyInterfaceScan.class.getCanonicalName());

    if (annotationAttributes != null) {
      String[] basePackages = (String[]) annotationAttributes.get("value");

      if (basePackages.length == 0){
        // If value attribute is not set, fallback to the package of the annotated class
        basePackages = new String[]{((StandardAnnotationMetadata) metadata).getIntrospectedClass().getPackage().getName()};
      }

      // using these packages, scan for interface annotated with MyCustomBean
      ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(false, environment){
        // Override isCandidateComponent to only scan for interface
        @Override
        protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
          AnnotationMetadata metadata = beanDefinition.getMetadata();
          return metadata.isIndependent() && metadata.isInterface();
        }
      };
      provider.addIncludeFilter(new AnnotationTypeFilter(MyCustomBean.class));

      // Scan all packages
      for (String basePackage : basePackages) {
        for (BeanDefinition beanDefinition : provider.findCandidateComponents(basePackage)) {
          // Do the stuff about the bean definition
          // For example, redefine it as a bean factory with custom atribute... 
          // then register it
          registry.registerBeanDefinition(generateAName() , beanDefinition);
          System.out.println(beanDefinition);
        }
      }
    }
  }
}