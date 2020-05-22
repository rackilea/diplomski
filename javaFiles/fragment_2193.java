public MyEntity findByName(final String name) {
    JPAQuery query = new JPAQuery(this.entityManager);
    QMyEntity myEntity;
    MyEntity result = jpaQuery.from(myEntity).where(myEntity.name.eq(name)).uniqueResult(myEntity);
    if (result ==  null)
        throw new EntityNotFoundException();
    else
        return result;
}