CustomerDid cd = CUSTOMER_DID.as("cd");
KnowService ks = KNOW_SERVICE.as("ks");
CustomerFlags cf = CUSTOMER_FLAGS.as("cf");

ctx.update(cd.leftJoin(kd)
             .on(ks.ID.eq(cd.CUSTOMER_SERVICE_ID))
             .leftJoin(cf)
             .on(ks.SERVICE_OWNER_ID.eq(cf.ACCOUNT_NUMBER)))
   .set(cd.IS_CLI_NUMBER, 1)
   .set(cf.IS_CLI_NUMBER, "0")
   .where(ks.SERVICE_OWNER_ID.eq(accountNumber))
   .and(cd.DID_NUMBER.eq(cliNumber))
   .execute();