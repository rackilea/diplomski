try {
    memberDao.create(newMember);
} catch (EJBTransactionRolledbackException e) {
    Throwable t = e.getCause();
    while ((t != null) && !(t instanceof ConstraintViolationException)) {
        t = t.getCause();
    }
    if (t instanceof ConstraintViolationException) {
        // Here you're sure you have a ConstraintViolationException, you can handle it
    }
}