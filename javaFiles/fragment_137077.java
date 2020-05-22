public ResultSet executeQuery(final String cql, final Object... values) {
    return executeWithSession(new SessionCallable<ResultSet>() {
        @Override
        public ResultSet executeWithSession(Session session) {
            BoundStatement bs = getStatement(cql, values);
            bs.setConsistencyLevel(consistencyLevel);
            return session.execute(cql);
        }
    });
}

// cache the prepared statement
private BoundStatement getStatement(final String cql, Object... values) {
    Session session = getSession();
    PreparedStatement ps = cache.get(cql);
    // no statement cached, create one and cache it now.
    if (ps == null) {
        ps = session.prepare(cql);
        PreparedStatement old = cache.putIfAbsent(cql, ps);
        if (old != null)
            ps = old;
    }
    return ps.bind(values);
}