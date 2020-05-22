public class MyClass {
    private Object token = null;
    private final Object tokenMonitor = new Object();

    // ...

    private Object getToken() {
        synchronized (tokenMonitor) {
            if (token == null) {
                return refreshToken(null);
            } else {
                return token;
            }
        }
    }

    private Object refreshToken(Object oldToken) {
        synchronized (tokenMonitor) {
            if (token == oldToken) {  // test reference equality
                token = methodToPerformARefreshAndGenerateANewToken();
            }
            return token;
        }
    }

    // ...
}