realmTitles = realm
   .where(RealmTitle.class)
   .contains("postCategories", "Semester - I")
   .and().not().like("postCategories", "*Semester - I*Semester - *")
   .and().not().contains("postCategories", "Semester - IV")
   .findAll();