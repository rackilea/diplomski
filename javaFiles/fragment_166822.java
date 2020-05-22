CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<? extends Object[]> cq = cb.createQuery(new Object[0].getClass());

Root<Cm> a = cq.from(Cm.class);
Join<Cm, CmParam> b = a.join("params", JoinType.LEFT);
cq.where(cb.equal(a.get("idCm"), cb.parameter(Long.class, "idCm")));
cq.groupBy(a.get("idCm"), a.get("type"));
cq.multiselect(
        a.get("idCm"),
        a.get("type"),
        cb.count(cb.selectCase()
                .when(cb.equal(b.get("status"), "PENDING"), 1L)
                .otherwise(cb.nullLiteral(Long.class))),
        cb.count(cb.selectCase()
                .when(cb.equal(b.get("status"), "FAILED"), 1L)
                .otherwise(cb.nullLiteral(Long.class))),
        cb.count(cb.selectCase()
                .when(cb.equal(b.get("status"), "PROCESSED"), 1L)
                .otherwise(cb.nullLiteral(Long.class))));