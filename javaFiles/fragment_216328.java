DSL.using(conn)
   .insertInto(CALLS)
   .columns(CALLS.USER_ID, CALLS.CALL_LINK)
   .values(
       DSL.field(
           DSL.select(USERS.ID)
              .from(USERS)
              .where(USERS.OKTELL_LOGIN.equal(oktell_login))
       )
       , link
   ).execute();