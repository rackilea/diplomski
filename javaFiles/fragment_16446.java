@Component
public class MyBean{
   //This must be a Spring Bean


   //Wiring the value to the field
   @Value("#{app.name}")
   private String name;
}