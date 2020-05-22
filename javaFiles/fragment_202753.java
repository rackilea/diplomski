@Configuration  
@ComponentScan(basePackages = {"com.stackoverflow.spring.hero"})
public class Config { }

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = 
                new AnnotationConfigApplicationContext(Config.class);

        Hero warrior = context.getBean(Warrior.class);
        warrior.killOrBeKilled();

        Hero archer = context.getBean(Archer.class);
        archer.killOrBeKilled();

        context.close();
    }
}