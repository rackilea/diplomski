CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<MyTable> cq = cb.createQuery(MyTable.class);
    Root<MyTable> root = cq.from(MyTable.class);

    Expression<String> week= new UnitExpression(null, String.class, "WEEK");
    Expression<Integer> timeDiff = cb.function(
        "TIMESTAMPDIFF",
        Integer.class,
        week,
        root.<Timestamp>get(MyTable_.until),
        root.<Timestamp>get(MyTable_.from));
    List<Predicate> conditions = new ArrayList<>();
    conditions.add(cb.greaterThan(timeDiff, 4));
    cq.where(conditions.toArray(new Predicate[]{}));
    return session.createQuery(cq);