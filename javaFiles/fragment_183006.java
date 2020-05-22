Query empQuery = session.createQuery(hqlQuery);
empQuery.setMaxResults(maxResult);
employees = (List<Employee>) empQuery.list();
for (Employee emp : employees) {
    Hibernate.initialize(emp.address);
}