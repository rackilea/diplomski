private volatile Helper helper = null;
public Helper getHelper() {
    if (helper == null) {
        synchronized(this) {
            if (helper == null) {
                helper = new Helper();
            }
        }
    }
    return helper;
}