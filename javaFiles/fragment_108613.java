String jpql = "select e from Employee e where e.homeAddress.id IN :addresses";
Set<Long> addressIds = Arrays.stream(addresses)
                             .map(Address::getId)
                             .collect(Collectors.toSet());
return em.createQuery(jpql, Employee.class)
         .setParameter("addresses", addressIds)
         .getResultList();