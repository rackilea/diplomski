@Configuration
public class MySingletonProvider {

  @Bean
  public MySingleton nameTheMethodExactlyLikeTheBeanNameYouWant(@Value("${singleton.xml.file}") String xmlConfigFile) {
    Library lib = new Library(xmlConfigFile);
    return new MySingleton(lib);
  }
}