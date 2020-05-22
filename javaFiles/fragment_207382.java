public static void main(String [] args){
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    SessionFactory factory = configuration.buildSessionFactory(new  StandardServiceRegistryBuilder().configure().build());
    Session session = factory.getCurrentSession();
    Transaction tx = session.getTransaction();

    Employee emp = new Employee();
    emp.setEmployeeName("Peter Jousha");
    emp.setEmployeeSalary(2000);
    emp.setEmployeeHireDate(new Date());

    session.save(emp);
    session.flush();    // <-- forces Hibernate to write your Employee to the database

    tx.commit();
    session.close();
}