public class MyClass {
    private static final String KEY = "my.instrumentation";
    public static void premain(String options, Instrumentation inst) {
        Properties props = System.getProperties();
        if(props.get(KEY) == null)
           props.put(KEY, inst);
    }

    public static Instrumentation getInstrumentation() { 
       return System.getProperties().get(KEY);
    }
}