sql.select(COMPANY.NAME, COMPANY_CONTACT.NAME.as("CONTACT_INTERACTION"))
   .from(COMPANY)
   .crossJoin(lateral(table(
        select(COMPANY_CONTACT.NAME)
       .from(COMPANY_CONTACT)
       .where(COMPANY_CONTACT.COMPANY_ID.eq(COMPANY.ID))
       .orderBy(COMPANY_CONTACT.FOLLOW_UP.desc())
       .limit(1)
   ).as(COMPANY_CONTACT)))
   .where(not(COMPANY.DELETED))
   .fetch();