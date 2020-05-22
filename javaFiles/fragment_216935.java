public void updateUser(String emailAccess) {

    String hql = "UPDATE User u set u.notifiable = true WHERE u.emailAccess = :emailAccess AND u.isAdmin = false";
    _sessionFactory.getCurrentSession().createQuery(hql).setParameter("emailAccess", emailAccess).executeUpdate();

}