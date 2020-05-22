public class ServerApp {

    public static void zzz() {
        System.out.println("hi");
    }

    public static void main(String[] args) throws Exception {
        String methodName = "zzz";

        java.lang.reflect.Method method = ServerApp.class.getMethod(methodName);
        method.invoke(ServerApp.class);
    }
}