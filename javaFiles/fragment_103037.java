Predicate id1 = criteriaBuilder.like(root.get(id), "%" + "1" + "%");
Predicate nameA = criteriaBuilder.like(root.get(name), "%" + "A" + "%");

    Predicate id1nameA = criteriaBuilder.and(id1,nameA);
    predicates.add(criteriaBuilder.or(id1nameA));
    //...continue for the others