@Value("${server.name:#{null}}")
private String someString;

private List<String> someList;

@PostConstruct
public void setList() {
  someList = someString == null ? Collections.emptyList() : Arrays.asList(someString.split(","));
}