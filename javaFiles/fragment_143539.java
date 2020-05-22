public List<Admin> getAdmins() {
    List<Admin> AdminList = new ArrayList<Admin>(); 
    Session session = factory.openSession();
    for (Object oneObject : session.createQuery("FROM Admin").getResultList()) {
        AdminList.add((Admin)oneObject);
    }
    session.close();
    return AdminList;
}