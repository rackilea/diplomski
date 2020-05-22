@Override
public void saveManager(Manager manager) {  
    Query query = sessionFactory.getCurrentSession().createQuery("update Manager set username = :username, password = :password where id = :id");
    query.setParameter("username", manager.getUsername());
    query.setParameter("password", manager.getPassword());
    query.setParameter("id", manager.getId());
    query.executeUpdate();
}