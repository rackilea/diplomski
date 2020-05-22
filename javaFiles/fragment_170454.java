static DBManager dbManager;

static {
    try {
        dbManager = DBManager.getInstance();
    }
    catch (Exception e) {
        throw new RuntimeException("Unable to geta DBManager instance", e);
    }
}