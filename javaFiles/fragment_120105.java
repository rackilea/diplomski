/**
 * Obtain a Hibernate Session, either from the current transaction or
 * a new one. The latter is only allowed if "allowCreate" is true.
 *.......
 */
protected final Session getSession()
    throws DataAccessResourceFailureException, IllegalStateException {
    return getSession(this.hibernateTemplate.isAllowCreate());
}