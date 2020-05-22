try {
    HibernateUtil.beginSession();
    Entity entity = dao.getEntityByUniqueProperty(propertyValue);
    if (entity==null){
        HibernateUtil.beginTransaction();
        try {
            entity = dao.addEntityByUniqueProperty(propertyValue)
            HibernateUtil.commitTransaction();
        } catch (ConstraintViolationException e){
            HibernateUtil.rollbackTransaction();
            HibernateUtil.closeSession();
            HibernateUtil.beginSession();
            entity = dao.getEntityByUniqueProperty(propertyValue);
            //Do other things additionally
        }
    }
    entity.setSomeProperty(otherPropertyValue);
    HibernateUtil.commitTransaction();
} catch (StaleStateObjectException e){
    HibernateUtil.rollbackTransaction();
    //Do other things additionally
} finally {
    HibernateUtil.closeSession();
}