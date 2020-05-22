public <T> Specification<T> dynamicLike2(String value, String... properties) {
    return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

        String[] values = value.split("\\s");
        int minNumber = Integer.min(values.length, properties.length);

        Predicate[] likes = new Predicate[minNumber];

        for (int i = 0; i < minNumber; i++) {
            likes[i] = cb.like(cb.lower(root.get(properties[i])), "%" + values[i].toLowerCase() + "%");
        }

        return cb.and(likes);
    };
}