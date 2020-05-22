public void updateValue(String value, String id, String ww){  
    CriteriaBuilder cb = this.em.getCriteriaBuilder();

      // create update
      CriteriaUpdate<TableAEntity> update = cb.
         createCriteriaUpdate(TableAEntity.class);

      // set the root class
      Root e = update.from(TableAEntity.class);

      // set update and where clause
      update.set(ww, value);
      update.where(cb.equalTo(e.get("num"), 
          id));

      // perform update
      this.em.createQuery(update).executeUpdate();
}