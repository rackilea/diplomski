public class Q42339586 {

    static class Sample {
        void a() { System.out.println("a() called"); }
        void b() { System.out.println("b() called"); }
    }

    static <T> void createInstanceAndCallMethod(
            Supplier<T> instanceSupplier, Consumer<T> methodCaller) {
        T o = instanceSupplier.get();
        methodCaller.accept(o);
    }

    public static void main(String[] args) {
        createInstanceAndCallMethodJava8(Sample::new, Sample::a);
    }

}