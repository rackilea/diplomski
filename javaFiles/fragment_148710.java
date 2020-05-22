public class Test {
    public static void main(String[] args) throws Exception {
        Test t = new Test();
        String param1 = "Foo", param2 = "Bar";

        String result = t.myMethod(SomeClass.class, x -> x.someMethod(param1, param2));

        System.out.println(result);
    }
    public <C, R> R myMethod(Class<? extends C> clazz, Function<C, R> method) throws Exception {
        C obj = clazz.getConstructor().newInstance();
        return method.apply(obj);
    }
}

class SomeClass {
    public SomeClass() {}
    public String someMethod(String param1, String param2) {
        return param1 + " + " + param2 + ": " + this;
    }
}