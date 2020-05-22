realmTitles = realm
   .where(RealmTitle.class)
   .like("postCategories", "*Semester - I")
   .or().contains("postCategories", "Semester - I,")
   .and().not().like("postCategories", "*Semester - *Semester - *")
   .findAll();