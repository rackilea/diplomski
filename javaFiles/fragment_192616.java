public class App
{
    public static void main(String[] args) throws NoSuchMethodException
    {
        Class<MyClass> c = MyClass.class;
        MyAnnotation a = c.getMethod("someMethod",null).getAnnotation(MyAnnotation.class);
        System.out.println(a.name());

        Class<MySubclass> c2 = MySubclass.class;
        a = c2.getMethod("someMethod",null).getAnnotation(MyAnnotation.class);
        System.out.println(a.name());
    }   
}

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
@interface MyAnnotation {
    String name() default "";
}

class MyClass {

    @MyAnnotation(name="Some value")
    public String someMethod() {
        return "Hi!";
    }
}

class MySubclass extends MyClass {

    @Override
    @MyAnnotation(name="Some other value")
    public String someMethod() {
        return super.someMethod();
    }
}