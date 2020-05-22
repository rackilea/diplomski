public List<Employee> findEmployeesInLeisureGroup(final Integer leisureGroupId) {
    final TypedQuery<Employee> query =
        em.createQuery("select e " +
                       "from Employee e join e.company c join c.leisureGroup l " +
                       "where l.id = :leisureGroupId", Employee.class);
    query.setParameter("leisureGroupId", leisureGroupId);
    return query.getResultList();
}