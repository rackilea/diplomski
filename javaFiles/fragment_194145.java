public List<TransactionEntryEntity> createCriteriaQuery(String cardHolderId, String accountId, int pageNumber,
        int pageSize, Map<String, String> allRequestParams) {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();

    CriteriaQuery<TransactionEntryEntity> cq = cb.createQuery(TransactionEntryEntity.class);
    // Root<CardHolderEntity> cardHolder = cq.from(CardHolderEntity.class);
    Root<TransactionEntryEntity> transactionEntry = cq.from(TransactionEntryEntity.class);

    Join<TransactionEntryEntity, TransactionEntity> transaction = transactionEntry
            .join(TransactionEntryEntity_.transactionEntity);

    List<Predicate> predicates = new ArrayList<Predicate>();
    // Default Predicates for transactions
    predicates
            .add(cb.equal(transactionEntry.get(TransactionEntryEntity_.cardHolderEntity).get(CardHolderEntity_.id),
                    cardHolderId));
    predicates.add(cb.equal(transactionEntry.get(TransactionEntryEntity_.valid), 'Y'));
    predicates.add(cb.equal(transaction.get(TransactionEntity_.retcode), "00"));

    // For Transaction API with acountId Path Variable
    if ((accountId != null) && (!accountId.trim().isEmpty())) {
        Join<TransactionEntryEntity, AccountEntity> account = transactionEntry
                .join(TransactionEntryEntity_.accountEntity);
        predicates.add(cb.equal(account.get(AccountEntity_.id), accountId));
    }
    if (!allRequestParams.isEmpty()) {
        String startDate = allRequestParams.get("minDate");
        String endDate = allRequestParams.get("maxDate");
        String merchantName = allRequestParams.get("merchantName");
        String date = allRequestParams.get("date");

        // Filter for Transactions with specific Date or with Start/End
        // date.
        if ((date != null) && !date.trim().isEmpty()) {
            predicates.add(cb.between(transaction.get(TransactionEntity_.date), DateUtil.getSqlStartDate(date),
                    DateUtil.getSqlEndDate(date)));
        } else if ((startDate != null) && (!startDate.trim().isEmpty()) && (endDate != null)
                && (!endDate.trim().isEmpty())) {
            predicates.add(cb.between(transaction.get(TransactionEntity_.date), DateUtil.getSqlStartDate(startDate),
                    DateUtil.getSqlEndDate(endDate)));
        } else if (((null == endDate) || (endDate.trim().isEmpty())) && (startDate != null)
                && (!startDate.trim().isEmpty())) {
            predicates.add(cb.greaterThanOrEqualTo(transaction.get(TransactionEntity_.date),
                    DateUtil.getSqlStartDate(startDate)));
        } else if (((null == startDate) || (startDate.trim().isEmpty())) && (endDate != null)
                && (!endDate.trim().isEmpty())) {
            predicates.add(cb.lessThanOrEqualTo(transaction.get(TransactionEntity_.date),
                    DateUtil.getSqlEndDate(endDate)));
        }

        // Filter by merchant name
        if (((merchantName != null) && !merchantName.trim().isEmpty())) {
            Join<TransactionEntity, MerchantEntity> merchant = transaction.join(TransactionEntity_.merchantEntity);
            predicates.add(
                    cb.like(cb.lower(merchant.get(MerchantEntity_.name)), "%" + merchantName.toLowerCase() + "%"));
        }
    }

    cq.select(transactionEntry).where(predicates.toArray(new Predicate[] {}));
    cq.orderBy(cb.desc(transaction.get(TransactionEntity_.date)));
    TypedQuery<TransactionEntryEntity> qry = entityManager.createQuery(cq);

    // For Paging of Transactions
    if ((pageNumber > 0) && (pageSize > 0)) {
        qry.setFirstResult((pageNumber - 1) * pageSize);
        qry.setMaxResults(pageSize);
    }
    return qry.getResultList();
}