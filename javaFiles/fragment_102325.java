import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestInnerBeanDependency {
       public static void main(String[] args) {
              ApplicationContext context =
                           new ClassPathXmlApplicationContext("beans.xml");
              Room room = (Room)context.getBean("room");             
              System.out.println(room);             
       }
}