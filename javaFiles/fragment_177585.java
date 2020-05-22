public void insert(Group group) throws DAOException {
    try {
        //your operation
        em.flush();
        logger.debug("insert() method has been successfully finisehd.");
    } catch (PersistenceException pe) {
        String sqlErroCode = getErrorCode(pe);
        // do your operation based on sql errocode
    }
}

protected String getErrorCode(RuntimeException e) {
    Throwable throwable = e;
    while (throwable != null && !(throwable instanceof SQLException)) {
        throwable = throwable.getCause();
    }
    if (throwable instanceof SQLException) {
        Properties properties = --> load sql error code form configuration file.
        SQLException sqlex = (SQLException) throwable;
        String errorCode = properties.getProperty(sqlex.getErrorCode() + "");
        return errorCode;
    }
    return "NONE";
}