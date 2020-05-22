public class MyMain {
    public static void main(String[] args) {
        MyService service = new MyServiceImpl();
        Collection<MyInterface> list = service.myMethod();
        // This works at runtime.
        System.out.println(list);
        for (MyInterface obj : list) {
            // This doesn't throw a ClassCastException
            System.out.println(obj);
        }
    }
}