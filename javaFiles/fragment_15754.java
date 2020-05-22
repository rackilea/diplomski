public class Test {
    public static void main(String[] args) {
        Class[] classes = new Class[]{Class1.class, Class2.class, Class3.class};
        for (Class cls : classes) {
            Object myObject = cls.newInstance();
            -------^^^^^^^^-------
        }
    }
}