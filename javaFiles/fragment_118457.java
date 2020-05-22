@Configuration
@Import(SpringConfigSecondLevel.class)
public class SpringTopLevelConfig {


    @Autowired SpringConfigSecondLevel springConfigSecondLevel;

    @Scope("prototype")
    @Bean
    Student student(){
        return new Student(springConfigSecondLevel.notebook());
    }
}

@Configuration
public class SpringConfigSecondLevel {

    @Scope("prototype")
    @Bean
    Notebook notebook(){
        return new Notebook();
    }
}