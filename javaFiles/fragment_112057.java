@Documented
    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.METHOD})
    public @interface SK08{
       public String name() default "SK08";
    }

Annotation Processing in Java Class:
=====================================
public class POJO {
    private String name;

    /**
     * @return the name
     */
    @SK08(name="Bangalore")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}

Processing class
==================
public class App {
    public static void main(String[] args) {
        POJO pojo = new POJO();
        setValue(pojo);
    }

    private static void setValue(POJO pojo) {
        for (Method method: pojo.getClass().getDeclaredMethods()) {
            for (Annotation annotation : method.getDeclaredAnnotations()) {
                if(annotation instanceof SK08){
                    System.out.println(((SK08)annotation).name());
                }
            }
        }
    }
}