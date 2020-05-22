public <T extends BusinessObject> T create(T bo, Class<T> cls) throws InstantiationException,
        SQLException, NamingException {

    final Dao<T, Long> dao = DaoManager.createDao(getConnectionSource(), cls);

    bo.setTimestampAdded(System.currentTimeMillis());
    bo.setTimestampModified(System.currentTimeMillis());
    bo.setDateAdded(new Date(System.currentTimeMillis()));
    bo.setDateModified(new Date(System.currentTimeMillis()));

    dao.create(bo);

    return bo;
}