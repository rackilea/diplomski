@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) 
@interface MyAnnotation {
    String value();
}

public class Main {
    @MyAnnotation(value = "onM1") public static void m1() { }
    @MyAnnotation(value = "onM1") public static void m() { }
    @MyAnnotation(value = "onM2") public static void m2() { }
    @MyAnnotation(value = "onM3") public static void m3() { }


    public static void main(String[] args) throws Exception {
        Method m = Main.class.getMethod("m1", new Class<?>[] {});
        Annotation onM1 = m.getAnnotation(MyAnnotation.class);

        m = Main.class.getMethod("m2", new Class<?>[] {});
        Annotation onM2 = m.getAnnotation(MyAnnotation.class);

        m = Main.class.getMethod("m3", new Class<?>[] {});
        Annotation onM3 = m.getAnnotation(MyAnnotation.class);

        m = Main.class.getMethod("m", new Class<?>[] {});
        Annotation onM = m.getAnnotation(MyAnnotation.class);

        List<Annotation> annots = Arrays.asList(onM1, onM2);

        System.out.println(annots);
        System.out.println(annots.contains(onM3));
        System.out.println(annots.contains(onM1));
        System.out.println(annots.contains(onM2));
        System.out.println(annots.contains(onM));
    }
}