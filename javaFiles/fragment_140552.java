public static Specification<Book> authorIdIs(Long authorId) {
    return new Specification<Book>() {
        @Override
        public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                Join join = root.join("authors");                   
                return cb.equal(join.get("id"),authorId);
        }
    };
}