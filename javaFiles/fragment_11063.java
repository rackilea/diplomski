public boolean createUser(NewUserDTO newUserDTO) {
    try {
        sessionFactory = DBUtils.getSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(newUserDTO);
        session.getTransaction().commit();
    } catch (RuntimeException runtimeException) {
        LOGGER.error(runtimeException);
        transaction.rollback();
        return false;
    } finally {
        if (session != null) {
            session.close();
        }
    }
    return true;
}