finally {
    // if session was used in an existing transaction restore old settings
    if (existingTransaction) {
        //logger.debug("Not closing pre-bound Hibernate Session after HibernateTemplate");
        disableFilters(session);
        if (previousFlushMode != null) {
            session.setFlushMode(previousFlushMode);
        }
    }
    // if not and a new session was opened close it
    else {
        // Never use deferred close for an explicitly new Session.
        if (newSessionOpened) {
            SessionFactoryUtils.closeSession(session);
            //_log.info("Closing opened Hibernate session");
        }
    }