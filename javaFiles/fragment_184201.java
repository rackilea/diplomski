entityManager.getTransaction().begin();
entityManager.delete(entity);
final Map deletedObjects = 
    ((RepeatableWriteUnitOfWork) entityManager
        .unwrap(UnitOfWork.class)).getDeleted();
// process deleted objects
entityManager.getTransaction().commit();