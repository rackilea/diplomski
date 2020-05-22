public class Singleton {
    public Enclosing getInstance() {
        return SingletonHolder.INSTANCE;
    }

    static enum SingletonHolder {
        INSTANCE;
    }
}