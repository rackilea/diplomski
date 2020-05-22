QueryBuilder<Account, String> qb = accountDao.queryBuilder();
     Where where = qb.where();
     // the name field must be equal to "foo"
     where.eq(Account.NAME_FIELD_NAME, "foo");
     // and
     where.and();
     // the password field must be equal to "_secret"
     where.eq(Account.PASSWORD_FIELD_NAME, "_secret");
     PreparedQuery<Account, String> preparedQuery = qb.prepareQuery();