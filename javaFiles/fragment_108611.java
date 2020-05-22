public class CHMHolder {

    private /*non-final*/ CHMHolder instance;

    public static CHMHolder getInstance() {
        if (instance == null) {
            instance = new CHMHolder();
        }
        return instance;
    }

    private ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, String> getMap() {
        return map;
    }
}