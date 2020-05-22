private Specification<QMyEntity> createFilterPredicate(final String filter, final QMyEntity root) {
        return new Specification<QMyEntity>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<QMyEntity> root, CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {
                Join<Object, Object> actionTime = root.join("actionTime", JoinType.LEFT);
                return criteriaBuilder.or(criteriaBuilder.like(criteriaBuilder.lower(root.get("id")), "%" + filter + "%"), criteriaBuilder.isNotNull(actionTime.get("startTime")));
            }
        };
    }