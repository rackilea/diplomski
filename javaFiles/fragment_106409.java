public [id_type] create(T entity) {
    getEntityManager().persist(entity);
    getEntityManager().flush();
    getEntityManager().refresh(entity);
    return entity.getId();
}