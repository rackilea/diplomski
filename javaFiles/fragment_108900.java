@Override
public void onPostUpdate(PostUpdateEvent event) {
    //Maybe you should try catch that !
    if ( event.getOldState() != null ) {
        final EntityPersister entityPersister = event.getPersister();
        final String[] propertiesNames = entityPersister.getPropertyNames();

        for ( int i = 0; i < propertiesNames.length; ++i ) {
            String propertyName = propertiesNames[i];
            if(checkProperty(propertyName){
                event.getOldState()[i] = event.getState()[i];
        }
    }
    // Normal Envers processing
    super.onPostUpdate(event);
}