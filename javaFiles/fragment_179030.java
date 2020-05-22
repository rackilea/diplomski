@Autowired
private Environment environment;

public void readValues() {
    System.out.println("Some Message:"
            + environment.getProperty("<Property Name>")); 

}