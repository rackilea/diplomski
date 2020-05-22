@EJB(name="ejb/carRepo", beanInterface=CarRepository.clas)
public class Main 
{
    public static void main(String[] args)

...
CarRepository carRepo = (CarRepository)new InitialContext().lookup("java:comp/env/ejb/carRepo");