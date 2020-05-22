public void modelChanged(final Change<? extends Order> change) {
    long timeSystem = System.currentTimeMillis();
    if(timeSystem - timeSinceLastEventManaged > MINIMUM_TIME){
        //do your stuff
        timeSinceLastEventManaged  = timeSystem;
    }
}