public class DrawingClass {

   static final Logger log = Logger.getLogger(DrawingClass.class);

public static void main(String args[])
{
    //without dependency injection 
    /*Triangle t1 = new Triangle();
    t1.draw();*/

    log.info("Before execution");
    //with dependency injection     
    BeanFactory factory = new XmlBeanFactory(new FileSystemResource("Spring.xml"));
    Triangle t1 =(Triangle) factory.getBean("triangle");
    t1.draw();
}
 }