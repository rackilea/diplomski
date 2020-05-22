public <T> CriteriaQuery<T> SimpleCriteria(EntityManager entityManager, Class<T>
        classEntity)throws InstantiationException,IllegalAccessException {

    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    return criteriaBuilder.createQuery(classEntity);
}