UsersStaging s = USERS_STAGING.as("s");

DSL.using(configuration)
   .update(USERS)
   .set(USERS.NAME, s.NAME)
   .set(USERS.CITY, s.CITY)
   .from(s)
   .where(USERS.ID.eq(s.ID))
   .execute();