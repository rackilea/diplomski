public void doSomething() throws MyException {
    try {
        // code which may throw HibernateException
    } catch (HibernateException e) {
        logger.log("Caught HibernateException", e);
        throw new MyException("Caught HibernateException", e);
    }
}