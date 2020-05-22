(...)
    //omitted class declaration here 
    public <T extends HasModeAttribute> void yourUpdate(T entity) {
        session = factory.openSession();
        tx = session.beginTransaction();
        if(entity.getMode() == 0){
           session.update(entity);
        }
        tx.commit();
        session.close();
    }

(...)