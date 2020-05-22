public <T> T doWithSession(Function<Session,T> f) {
    Session session = sessionFactory.openSession();
    try {
        return f.apply(session);
    }
    finally {
        session.close();
    }
}