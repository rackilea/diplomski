@Bean(name = "list")
  public List<String> getList() {
    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    return list;
  }

  @Bean
  public Object getInstance(Map<Integer, List<String>> map, String someString, @Qualifier("list")List<String> list) {
    ...
  }