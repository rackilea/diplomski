public class ServerApp {

    public void foo() {
        System.out.println("Hello there from non static method!");
    }

    public static void main(String[] args) throws Exception {
        String methodName = "foo";

        ServerApp app = new ServerApp();
        java.lang.reflect.Method method = app.getClass().getMethod(methodName);
        method.invoke(app);
    }
}