public List<Admin> getAdmins() {
    Session session = factory.openSession();
    TypedQuery<Admin> query = session.createQuery("FROM Admin");
    List<Admin> result = query.getResultList();
    session.close();
    return result;
}