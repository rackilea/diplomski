public static MysqlDb getInstance() {
    if (instance == null) {
        instance = new MysqlDb();
    }
    return instance;
}