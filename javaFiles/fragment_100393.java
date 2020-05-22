@Configuration //typo corrected
class SomeServiceFactory {

  @Autowired // Spring will Autowire all instances of SomeService with bean name as key
  Map<String, SomeService> someServiceMap;

  public SomeService getSomeServiceByName(String name) {
    return someServiceMap.get(name);
  }
}