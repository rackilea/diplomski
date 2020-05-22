@Transactional
public <S extends T> S save(S entity) {

    if (entityInformation.isNew(entity)) //checks if ID null {
        em.persist(entity);
        return entity;
    } else {
        return em.merge(entity);
    }
}