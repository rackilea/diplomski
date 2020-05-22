private static volatile MyDAO();
 public synchronized static MyDAO getInstance() {
    if (instance == null) {
        instance = new MyDAO();
    }
    return instance;