@Configuration
    public class Config {
    @Bean(name = "circle1")
    public Circle getCircle1(){
        Circle c = new Circle();
        c.setRadius(1.5);
        return c;
    }

    @Bean(name = "circle2")
    public Circle getCircle2(){
        Circle c = new Circle();
        c.setRadius(10);
        return c;
    }
    }