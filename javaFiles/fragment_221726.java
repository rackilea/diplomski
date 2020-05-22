package basepackage.config;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages={"basepackage.data"})
@EntityScan(basePackageClasses=User.class)
@ComponentScan(basePackages={"basepackage"})
public class MyConfig {

@Autowired
private UserRepository repo;

@PostConstruct
public void init(){
    for(int i=0; i<10; i++){
        repo.save(new User("u-"+i));
    }

}

}