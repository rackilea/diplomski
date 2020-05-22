public <T> Specification<T> dynamicLike(String likeValue, String... properties) {
    return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

        Expression<String> concat = null;

        for (String property : properties) {
            if (concat == null) {
                concat = cb.concat("", root.get(property));
            } else {
                concat = cb.concat(concat, cb.concat(" ", root.get(property)));
            }
        }

        return cb.like(cb.lower(concat), "%" + likeValue.toLowerCase() + "%");
    };
}