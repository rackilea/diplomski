JPAQuery<Integer> query = queryFactory.query()
        .select(coopMember.memberId)
        .distinct()
        .from(coopMember)
        .leftJoin(coopMember.personId.bankAccountId, bankAccount)
        .where(coopMember.voided.isFalse());
    if( bankId != null ){
        query.where(
                bankAccount.isNotNull().and(bankAccount.bankBranch.bankId.eq(bankId))
        );
    }