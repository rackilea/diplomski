package asif.hossain;

    import java.lang.annotation.*;
    import java.lang.reflect.Field;

    /**
     *
     * Created by sadasidha on 21-Aug-14.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface MyAnnotation {
        public String value();
    }
    class TestClass
    {
        @MyAnnotation("This is a name field")
        public String name;
    }
    public class Main {
        public static void main(String ... args) throws IllegalAccessException {
            TestClass testObject = new TestClass();
            Field[] fields = testObject.getClass().getFields();
            for (Field field : fields)
            {
                Annotation annotation = field.getAnnotation(MyAnnotation.class);
                if(annotation instanceof MyAnnotation)
                {
                    System.out.println(field.getName());
                    // get field value
                    String value = (String)field.get(testObject);
                   System.out.println("Field Value = "+ value);
                    //Set field value
                    field.set(testObject,"Your Name");
                    System.out.println(testObject.name);
                }
            }
        }
    }