public static void main(String[] args) throws Exception{
    Class<?> randomImplClass = RandomImpl.class;
    System.out.println(randomImplClass);
    Easy annotation = randomImplClass.getAnnotation(Easy.class);
    System.out.println("Class: " + randomImplClass);
    System.out.println("Class Annotation: " + annotation);

    Method method = randomImplClass.getMethod("doRandom");
    annotation = method.getAnnotation(Easy.class);
    System.out.println("Method: " + method);
    System.out.println("Method Annotation: " + annotation);
}

public static class RandomImpl implements Random{}
@Easy
interface Random {
    @Easy
    default void doRandom() {System.out.println("testing");};
}

@Target(value = {METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Easy {}