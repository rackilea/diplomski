@Autowired
private Environment environment;

public void doSomething(Environment env) {
    System.out.println(env.getProperty("db.password"));
}