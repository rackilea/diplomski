public static Specification<Car> withLicensePlate(String licensePlate) {
    return (root, query, cb) -> licensePlate == null ? null : cb.equal(root.get("licensePlate"), licensePlate);
}

public static Specification<Car> withRating(String rating) {
    return (root, query, cb) -> rating == null ? null : cb.equal(root.get("rating"), rating);
}

public static Specification<Car> withName(String name) {
    return (root, query, cb) -> name == null ? null : cb.equal(root.get("name"), name);
}