SQLQueryFactory sqlqf; // Should be @Autowired

QUsers qusers = new QUsers();
QPayouts qpayouts = new QPayouts();

Expression<Long> memberId = ExpressionUtils.as(qpayouts.memberId, "mmb_id");
Expression<Double> totalPayouts = ExpressionUtils.as(qpayouts.amount.sum(), "totalPayouts");

SQLQuery<Tuple> payoutsBbf = SQLExpressions.select(memberId, totalPayouts)
            .from(qpayouts)                
            .where(qpayouts.payoutPeriod.lt("2018-01-01")) // Use date object
            .groupBy(qpayouts.memberId);

final SimplePath<? extends SQLQuery> payoutsBBfPath = Expressions.path(payoutsBBfPath.getClass(), "payoutsBbf");

List<Tuple> fetch = sqlqf.select(
        qusers.memberId,                
        Expressions.path(payoutsBbf.getClass(), new PathMetadata(payoutsBBfPath, "totalPayouts", PathType.PROPERTY))
    )
    .from(qusers)
    .leftJoin(payoutsBbf, payoutsBBfPath)
    .addJoinFlag(" on payoutsBbf.mmb_id = users.id", JoinFlag.Position.BEFORE_CONDITION)
    .fetch();