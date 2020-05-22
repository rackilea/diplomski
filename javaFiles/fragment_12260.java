private <E> List<E> findListPage(final String hql, final int offset,
        final int limit, final Object... args) {
    return (List<E>) getHibernateTemplate().execute(new HibernateCallback() {
        public Object doInHibernate(Session session) throws HibernateException,
                SQLException {
            Query query = createQueryAndPopulateParameters(session, hql,
                    args);
            if (offset >= 0) {
                query.setFirstResult(offset);
            }
            if (limit >= 0) {
                query.setMaxResults(limit);
            }
            return query.list();
        }
    });
}

private Query createQueryAndPopulateParameters(Session session,
        final String hql, final Object... args) {
    Query query = session.createQuery(hql);
    for (int i = 0; i < args.length; i++) {
        query.setParameter(i, args[i]);
    }
    return query;
}

public List<Movie> listMoviesPaged(int offset, int limit) {
    return findListPage("from Movie m order by m.id", offset, limit);
}