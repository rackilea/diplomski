import java.util.List;

public class Teacher {

    private String userName;
    private String cource;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCource() {
        return cource;
    }

    public void setCource(String cource) {
        this.cource = cource;
    }
}

public class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


public class ClassFacadeCglib implements MethodInterceptor{

    private Object target; 

    public Object getInstance(Object target) {  
        this.target = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.target.getClass());  
        // callback method
        enhancer.setCallback(this);  
        // create proxy object
        return enhancer.create();  
    }  

    @Override
    public Object intercept(Object obj, Method method, Object[] args,  
        MethodProxy proxy) throws Throwable {

        if(method.getName().startsWith("set")){
                System.out.println(method.getName()+" start");  
                proxy.invokeSuper(obj, args);  
                System.out.println(method.getName()+" end..");  
        }

        if(method.getName().startsWith("get")){
            System.out.println(method.getName()+" start");  
            proxy.invokeSuper(obj, args);  
            System.out.println(method.getName()+" end");  
        }

        return null;  
    }

}


public class Main {

    public static void main(String[] args) {  
        ClassFacadeCglib cglib=new ClassFacadeCglib();  
        Teacher teacher=(Teacher)cglib.getInstance(new Teacher());  
        teacher.setCource("Math");
        teacher.getUserName(); 
    } 

}