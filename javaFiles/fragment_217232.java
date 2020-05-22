@Configuration
public class config{
    @Bean
    public ClassA a(){
        return new ClassA();
    }
}

@Import({config.Class}) // import Bean for ClassA