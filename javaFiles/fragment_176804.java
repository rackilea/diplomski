public class SomeClass {

    private final Map<String, Runnable> methods = new HashMap<>();
    {
        methods.put("helloworld", () -> {
            System.out.println("Hello World!");
        });
        methods.put("test", () -> {
            System.out.println("test!");
        });
        methods.put("doStuff", () -> {
            System.out.println("doStuff!");
        });
    }

    public void perform(String code) {
        methods.getOrDefault(code, 
            () -> {
                System.err.println("No such Method: "+code);
            })
        .run();
    }

}