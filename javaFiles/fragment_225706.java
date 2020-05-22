public void SimpleCriteria(EntityManager entityManager, Class
            classEntity)throws InstantiationException,IllegalAccessException {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery =
                criteriaBuilder.createQuery(classEntity);
    }