String customQueryFindJonDoe = 
       "select e from Employee e where e.firstName = :firstname and e.lastName = :lastName";
EntityManager entityManager = JPAUtils.openEntityManager();

TypedQuery<Employee> q = entityManager.createQuery(customQueryFindJonDoe, Employee.class);
q.setParameter("firstname", "Jon");
q.setParameter("lastName", "Doe");

List<Employee> foundJonDoe = q.getResultList();