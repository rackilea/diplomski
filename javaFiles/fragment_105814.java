Select<Result1<Integer>> fetchOne(Condition condition) {
    return db.select(T1.C1)
             .from(T1)
             .where(T1.C2.eq(v1))
             .and(condition)
             .fetchOne();
}

var result = fetchOne(T1.C3.eq(v2));

if (result == null)
    result = fetchOne(T1.C3.eq(v3));