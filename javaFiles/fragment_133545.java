public class MyGlobalKeys {
    private static final MyGlobalKeys globals = new MyGlobalKeys();

    // disable construction outside of this class
    private MyGlobalKeys() {}

    public void getInstance() {
       return globals;
    }

    public void addKey(String key, bool state) { ... }
    public bool hasKey(String key) { ... }
    // and so on ...
}