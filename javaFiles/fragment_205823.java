JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);

QCustomer customer = QCustomer.customer;

List<Study> result = queryFactory.selectFrom(customer)
                                 .where(customer.firstName.eq("Bob"))
                                 .fetchOne();