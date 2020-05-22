public void delete(Integer id) {

    LOGGER.debug("Deleting existing user");
    Session session = sessionFactory.getCurrentSession();
    User user = (User) session.get(User.class, id);
    session.delete(user);
}