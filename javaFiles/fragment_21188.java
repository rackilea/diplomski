@Configuration
public class YourConfiguration {

  @Bean(name = "org.dozer.Mapper")
  public DozerBeanMapper dozerBean() {
    List<String> mappingFiles = Arrays.asList(
      "dozer-global-configuration.xml", 
      "dozer-bean-mappings.xml",
      "more-dozer-bean-mappings.xml"
    );

    DozerBeanMapper dozerBean = new DozerBeanMapper();
    dozerBean.setMappingFiles(mappingFiles);
    return dozerBean;
  }

  ...
}