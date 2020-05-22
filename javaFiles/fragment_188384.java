public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();

        Test<Integer> testInt = injector.getInstance(Key.get(new TypeLiteral<Test<Integer>>() {}));
        testInt.action();

        Test<String> testString = injector.getInstance(Key.get(new TypeLiteral<Test<String>>() {}));
        testString.action();
    }

    public static class Test<T> {
        private final Class<? super T> clazz;

        @Inject
        public Test(TypeLiteral<T> literal) {
            this.clazz = literal.getRawType();
        }

        public void action() {
            System.out.println(clazz);
        }
    }
}