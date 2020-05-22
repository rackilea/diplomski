@Value("${app.users-location}")
Resource[] resources;

@PostConstruct
public void init(){
    System.out.println(resources);
}