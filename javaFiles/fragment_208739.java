public class MyContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDBContext(String dBContext) {
        contextHolder.set(dBContext);
    }

    public static String getDBContext() {
        return (String) contextHolder.get();
    }

    public static void clearDBContext() {
        contextHolder.remove();
    }

}