CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Object[]> qDef = cb.createQuery(Object[].class);
Root<EmployeeEntity> e = qDef.from(EmployeeEntity.class);
qDef.multiselect(
     e.get(EmployeeEntity_.employeeId),
     e.get(EmployeeEntity_.employeeContactInfo).get(ContactInfoEntity_.phone));
qDef.where(
     cb.equal(
        e.get(EmployeeEntity_.employeeContactInfo).get(ContactInfoEntity_.zipCode), 
        cb.literal("123456")));

List<Object[]> objects = em.createQuery(qDef).getResultList();
for (Object[] element : objects) {
    System.out.format("%d %s", element[0], element[1]);
}