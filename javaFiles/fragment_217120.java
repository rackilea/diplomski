List<Book> result = hibernateTemplate.execute(new HibernateCallback<List<Book>>() {
    public List<Book> doInHibernate(Session session) throws HibernateException, SQLException {
        Query query = session.createQuery("SELECT DISTINCT b FROM Book as b LEFT JOIN FETCH b.authors");

        List list = query.list();

        return list;
    }
});