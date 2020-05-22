val owners = USERS.as("owners");
val reviewers = USERS.as("reviewers");

sql
  .select()
  .from(ITEMS.join(ITEMSOWNERS).on(ITEMSOWNERS.ITEM_ID.eq(ITEMS.ID)))
             .join(owners).on(ITEMSOWNERS.OWNER_ID.eq(owners.ID))
             .leftJoin(ITEMSREVIEWERS).on(ITEMSREVIEWERS.ITEM_ID.eq(ITEMS.ID))
             .join(reviewers).on(ITEMSREVIEWERS.REVIEWER_ID.eq(reviewers.ID))
  .where(PUBLIC_ID.eq(publicId))
  .fetchGroups(WALLETS)