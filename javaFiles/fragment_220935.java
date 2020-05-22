public boolean deleteLoop(String parentId) {
    PersistenceManager pm = PMF.getInstance().getPersistenceManager();
    Transaction tx = pm.currentTransaction();
    try {
        tx.begin();
        pm.setDetachAllOnCommit(true);
        Parent parent = null;

        Key parentKey = KeyFactory.stringToKey(parentId);
        loop = pm.getObjectById(Parent.class, parentKey);

        Parent detachedParent = pm.detachCopy(parent);

                    // this was indeed not necessary
        //pm.deletePersistent(detachedParent.getChildList());

                    // no detachment issues, object deletes just fine.
        pm.deletePersistent(detachedParent);

        tx.commit();
        //pm.close();

    } catch(Exception e) {
        log.error("Exception trying to delete Parent :: ",e);
        e.printStackTrace();


    } finally {

        if(tx.isActive()) {
            tx.rollback();
        }

        pm.close();
    }
}