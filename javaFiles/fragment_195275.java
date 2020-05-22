public class BasicEntityLifecycleListener implements StoreLifecycleListener {

    public void postStore(InstanceLifecycleEvent evt) {
    }

    public void preStore(InstanceLifecycleEvent evt) {
        if((PersistenceCapable)evt.getSource() instanceof BasicEntity) {
            BasicEntity obj = (BasicEntity)evt.getSource();
            Date now = new Date();
            if(JDOHelper.isNew(obj))
                obj.setCreated(now);
            obj.setLastUpdate(now);
        }
    }
}