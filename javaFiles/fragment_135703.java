CriteriaQuery<Tuple> cq = cb.createTupleQuery();
...
cq.select(
   cb.tuple(
      e.get(EmployeeEntity_.employeeId)
       .alias("id"),
      e.get(EmployeeEntity_.employeeContactInfo).get(ContactInfoEntity_.phone)
       .alias("phone")));
...
List<Tuple> tuple = em.createQuery(cq).getResultList();
for (Tuple element : tuple) {
    System.out.format("%d %s", element.get("id"), element.get("phone"));
}