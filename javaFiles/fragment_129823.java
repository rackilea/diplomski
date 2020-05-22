public static Specification<Pet> ownerNameEqual(String ownerName) {
        return new Specification<Pet>() {
            @Override
            public Predicate toPredicate(Root<Pet> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Join<Pet, Owner> owners = root.join("owners");
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
                return criteriaBuilder.equal(owners.get("name"), ownerName);
            }
        };
    }