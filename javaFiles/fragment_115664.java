public Note findByKey(Long key) {
    Note detachedCopy=null, object=null;
    try{
        pm= PMF.get().getPersistenceManager();
        object = pm.getObjectById(Note.class,key);
        detachedCopy = pm.detachCopy(object);
    }catch (JDOObjectNotFoundException e) {
        return null; // or whatever
    } 
    finally {
        pm.close(); // close here
    }
    return detachedCopy;

}