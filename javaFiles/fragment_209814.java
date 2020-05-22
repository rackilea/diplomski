EnvironmentConfig envConfig = new EnvironmentConfig();

try {
    myDbEnvironment_ = new Environment(new File(getDatabasePathString()), envConfig);
} catch (DatabaseException e) {
    e.printStackTrace();
}
DAO.store_ = new EntityStore(environment, "EntityStore", new StoreConfig());
Index_ = store_.getPrimaryIndex(String.class, Page.class);