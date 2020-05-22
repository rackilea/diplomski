boolean reidentifyNeed = false;

try {

    DofinService.getEntityManagerThreadLocal().getTransaction().begin();

    DofinService.getEntityManagerThreadLocal().persist(entity);

    try {

        DofinService.getEntityManagerThreadLocal().getTransaction().commit();

        //if commit is successfull
        entityIdInDB = (long) entity.getId();

        DofinService.getEntityManagerThreadLocal().clear();

    } catch (Exception ex) {

        logger.error("Error committing " + entity.getClass().getSimpleName() + " in DB. Possibly duplicate object. Will try to re-identify object. Error: " + ex.toString());

        reidentifyNeed = true;

    }

    if(reidentifyNeed){
        //need clear entityManager, because if duplicated object was persisted then during *select* an object flush() method will be executed and it will thrown ConstrainViolationException 
        DofinService.getEntityManagerThreadLocal().clear();

        CheckSimilarObject checkSimilarObject = new CheckSimilarObject();

        long objectId = checkSimilarObject.checkObject(dofinObject);

        logger.warn("Re-identifying was done. EntityId = " + objectId);

        entityIdInDB = objectId;
    }

} catch (Exception ex) {
    logger.error("Error persisting and commiting object: " + ex.toString());
}