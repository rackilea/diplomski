@Override
 public <S extends T> S More ...save(S entity) {
     Assert.notNull(entity, "Entity must not be null");
     Name declaredId = odm.getId(entity);

     if (isNew(entity, declaredId)) {
         ldapOperations.create(entity);
     } else {
         ldapOperations.update(entity);
     }

     return entity;
 }