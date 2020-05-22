public static synchronized Singleton getInstance() {
    if (unique == null) {
        synchronized (Singleton.class) {
            if (unique == null) {  
                unique = new Singleton();
            }
        }
    }
    return unique;
}