boolean newSessionOpened = false;
Session session;

if (enforceNewSession){
    session = SessionFactoryUtils.openSession(getSessionFactory());
    newSessionOpened = true;
} else {
    try {
        // look for an open session
        session = getSessionFactory().getCurrentSession();
    }
    catch (HibernateException ex) {
        try {
            // if there isn't an open session, open one yourself
            session = getSessionFactory().openSession();
            newSessionOpened = true;
        } catch (HibernateException e) {
            throw new DataAccessResourceFailureException("Could not open Hibernate Session", ex);
        }
    }
}

// is the open session, is a session in a current transaction?
boolean existingTransaction = (!enforceNewSession &&
        (!isAllowCreate() || isSessionTransactional(session, getSessionFactory())));