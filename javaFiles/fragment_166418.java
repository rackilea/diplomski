private <S extends T> boolean More ...isNew(S entity, Name id) {
     if (entity instanceof Persistable) {
         Persistable<?> persistable = (Persistable<?>) entity;
         return persistable.isNew();
     } else {
         return id == null;
     }
 }