public static Specification<A> containsBWithName(String name) {
    return (root, query, cb) -> {
        root.join("bList", JoinType.INNER);
        return cb.equal(root.get("bList").get("name"), name);
    };
}