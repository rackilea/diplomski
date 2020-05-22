@Value("${myCalculatedProperty}")
private String magic;

@PostConstruct
public void init() {
    System.out.println("Magic: " + magic);
}