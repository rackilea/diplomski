DSL.using(conn)
   .insertInto(CALLS)
   .columns(CALLS.USER_ID, CALLS.CALL_LINK)
   .values(
       DSL.using(conn) // Use DSLContext, not DSL here
          .select(USERS.ID)
          .from(USERS)
          .where(USERS.OKTELL_LOGIN.equal(oktell_login))
          .fetchOne().value1()
       , link
   ).execute();