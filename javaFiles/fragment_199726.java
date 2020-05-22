public static Specification<Entity> byColumnNameAndValue(String columnName, String value) {
    return new Specification<Entity>() {
        @Override
        public Predicate toPredicate(Root<Entity> root,
                CriteriaQuery<?> query, CriteriaBuilder builder) {
            return builder.equal(root.<String>get(columnName), value);
        }
    };
}