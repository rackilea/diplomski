public class SpringFirst1 {

public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
    Student s1 = context.getBean(Student.class);
    s1.setName("Gaurav");
    System.out.println(s1.getName());
}