@SuppressWarnings("unchecked")
public Collection<Owner> findByPetType(Integer typeID) {
     Query query = this.em.createQuery("SELECT DISTINCT owner FROM Owner owner left join fetch owner.pets as pet WHERE pet.type.id = :typeID");
    query.setParameter("typeID", typeID);
    return query.getResultList();
}