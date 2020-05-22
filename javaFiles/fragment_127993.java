public Helper getHelper() {
    if (helper == null) {
        synchronized(this) {
            helper = new Helper();
        }
    }
    return helper;
}