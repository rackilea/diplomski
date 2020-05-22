@SpringBootApplication
@EntityScan(basePackageClasses = {Entity1.class}) 
// use basePackageClasses to avoid type errors
@Import({com.a.b.EntityConfig.class}) // this is what you are missing
public class Applciation
{
    public static void main(String args[])
    {
         SpringApplication.run(Applciation.class, args);
    }
}