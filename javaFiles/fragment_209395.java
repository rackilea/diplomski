public List<Person> findByName(String name) {
    return persistence.entityManager().createQuery(
                "Select p from Person p +
                        " where p.name= :uniqueId" , Person.class)
                .setParameter("name", name)
                .getResultList();
}