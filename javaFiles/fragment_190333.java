@Transactional
public User getUser(int id) {
    User user = userDAO.getUser(id);
    Hibernate.initialize(user.getComments());
    return user;
}