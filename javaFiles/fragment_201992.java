@SpringBootApplication
public class GracefulShutdownApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(GracefulShutdownApplication.class, args);
        try{
            ctx.getBean("watchService");
        }catch(NoSuchBeanDefinitionException e){
            System.out.println("No folder to watch...Shutting Down");
            ctx.close();
        }
    }

}