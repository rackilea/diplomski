@Bean
public ChildClass childClass() {
    return new ChildClass(customParam());
 }

  @Bean
public CustomParam customParam() {
    return new CustomParam(5);
 }