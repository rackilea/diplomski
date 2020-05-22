B[] subset = new B[] {b3, b5};
        DetachedCriteria.forClass(A.class).createAlias("bs", "b");

        for (B b : subset) {
            criteria.add(Restrictions.eq("b.id", b.getId()));
        }