private static final Object INSTANCE_LOCK = new Object();

public static Clients getInstance() {
    synchronized(INSTANCE_LOCK) {
        if(instance == null) instance = new Clients();
    }
    return instance;
}