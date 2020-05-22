// begin tx
...
SomeEntity e = em.find(SomeEntity.class, id);
// change the entity
em.lock(e, LockModeType.OPTIMISTIC); // LockModeType.OPTIMISTIC_FORCE_INCREMENT
...
// commit tx