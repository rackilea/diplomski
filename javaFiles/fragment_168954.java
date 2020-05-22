CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
CriteriaQuery<Cars> criteriaQuery = criteriaBuilder.createQuery(Cars.class);
Metamodel metamodel = entityManager.getMetamodel();
Root<Cars> root = criteriaQuery.from(metamodel.entity(Cars.class));

Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
Root<Bookings> subRoot = subquery.from(metamodel.entity(Bookings.class));
subquery.select(criteriaBuilder.literal(1L));

List<Predicate> predicates = new ArrayList<Predicate>();

ParameterExpression<Date> fromDate1 = criteriaBuilder.parameter(Date.class);
Predicate exp1 = criteriaBuilder.lessThanOrEqualTo(subRoot.get(Bookings_.fromDate), fromDate1);
ParameterExpression<Date> toDate1 = criteriaBuilder.parameter(Date.class);
Predicate exp2 = criteriaBuilder.greaterThanOrEqualTo(subRoot.get(Bookings_.toDate), toDate1);
Predicate and1 = criteriaBuilder.and(exp1, exp2);

ParameterExpression<Date> fromDate2 = criteriaBuilder.parameter(Date.class);
Predicate exp3 = criteriaBuilder.lessThanOrEqualTo(subRoot.get(Bookings_.fromDate), fromDate2);
ParameterExpression<Date> toDate2 = criteriaBuilder.parameter(Date.class);
Predicate exp4 = criteriaBuilder.greaterThanOrEqualTo(subRoot.get(Bookings_.toDate), toDate2);
Predicate and2 = criteriaBuilder.and(exp3, exp4);

ParameterExpression<Date> fromDate3 = criteriaBuilder.parameter(Date.class);
Predicate exp5 = criteriaBuilder.greaterThanOrEqualTo(subRoot.get(Bookings_.fromDate), fromDate3);
ParameterExpression<Date> toDate3 = criteriaBuilder.parameter(Date.class);
Predicate exp6 = criteriaBuilder.lessThanOrEqualTo(subRoot.get(Bookings_.toDate), toDate3);
Predicate and3 = criteriaBuilder.and(exp5, exp6);

Predicate equal = criteriaBuilder.equal(root, subRoot.get(Bookings_.fkCarId));
Predicate or = criteriaBuilder.or(and1, and2, and3);
predicates.add(criteriaBuilder.and(or, equal));
subquery.where(predicates.toArray(new Predicate[0]));

criteriaQuery.where(criteriaBuilder.exists(subquery).not());

List<Cars> list = entityManager.createQuery(criteriaQuery)
        .setParameter(fromDate1, new Date("2015/05/04"))
        .setParameter(toDate1, new Date("2015/05/04"))
        .setParameter(fromDate2, new Date("2015/05/06"))
        .setParameter(toDate2, new Date("2015/05/06"))
        .setParameter(fromDate3, new Date("2015/05/04"))
        .setParameter(toDate3, new Date("2015/05/06"))
        .getResultList();