CriteriaQuery<EmployeeEntityResult> cq = cb.createQuery(EmployeeEntityResult.class);
...
List<EmployeeEntityResult> result = em.createQuery(cq).getResultList();
for (EmployeeEntityResult element : result) {
    System.out.format("%d %s", element.getId(), element.getPhone());
}