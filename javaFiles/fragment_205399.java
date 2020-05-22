public List<String> getComments(long id) {
    Session session = sessionFactory.openSession();

    List<String> comments = getPersonById(id).getComments();

    sessionFactory.getCurrentSession().flush();
    sessionFactory.getCurrentSession.close();

    return comments;
}