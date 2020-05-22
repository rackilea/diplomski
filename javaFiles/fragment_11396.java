public static Specification<Grp> status(final String status) {
    // EQUAL clause
    return (grp, query, cb) -> cb.equal(grp.<String>get("status"), status);
}

public static Specification<Grp> companyIds(final List<Long> companyIds) {
    // IN clause
    return (grp, query, cb) -> grp.<Long>get("co_id").in(companyIds);
}