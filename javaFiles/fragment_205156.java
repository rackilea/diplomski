private Dao<ModelStore, Integer> modelStoreDao = null;
...

public Dao<ModelStore, Integer> getDaoStore() throws SQLException {
    if (modelStoreDao == null) {
        modelStoreDao = DaoManager.createDao(getConnectionSource(),
            ModelStore.class);
    }
    return modelStoreDao;
}