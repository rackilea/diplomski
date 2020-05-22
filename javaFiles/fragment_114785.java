CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);
Root<ATable> a = criteria.from(ATable.class);
Join<ATable, BTable> b = a.join("b");
Join<ATable, BTable> b2 = a.join("b");

criteria.where(cb.or(
        cb.and(
                cb.equal(b.get("status"), cb.literal(Status.INITIAL)),
                a.get("main").isNull()),
        cb.and(
                cb.equal(b2.get("status"), cb.literal(Status.INITIAL)),
                cb.equal(b2.get("main"), a)
                )));

criteria.multiselect(a.get("id"), b.get("status"));