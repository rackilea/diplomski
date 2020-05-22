public class ObjectLock implements Serializable,HttpSessionBindingListener {
    public void valueBound(HttpSessionBindingEvent event) {
        log.info("valueBound:" + event.getName() + " session:" + event.getSession().getId() );

    }

    public void registerSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put( "sessionBindingListener", this  );
        log.info( "registered sessionBindingListener"  );
    }

    public void valueUnbound(HttpSessionBindingEvent event) {
        log.info("valueUnBound:" + event.getName() + " session:" + event.getSession().getId() );
               // add you unlock code here:
        clearLocksForSession( event.getSession().getId() );
    }
}