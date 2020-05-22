public class Scratch4 {
    public static void main(String args[]) throws Exception {
        B b = new D();

        Class<B> bClazz = B.class;
        Method bClazzMethod = bClazz.getMethod("f", E.class);

        bClazzMethod.invoke(b, new E());
    }
}