public class CustomEnversPostUpdateEventListener 
       extends EnversPostUpdateEventListenerImpl {
    public CustomEnversPostUpdateEventListener(EnversService enversService) {
      super( enversService );
    }

    @Override
    public void onPostUpdate(PostUpdateEvent event) {
      final String entityName = event.getPersister().getEntityName();
      if ( getEnversService().getEntityConfigurations().isVersioned( entityName ) ) {
         if ( MySpecialEntity.class.getName().equals( entityName ) ) {
           // Compare event.getState() against event.getOldState()
           // Determine if only your special String changed or not
           if ( !otherFieldsChangedBesidesSpecialProperty ) { 
             return;
           }
         }
         // delegate to default implementation
         super.onPostUpdate( event );
      }
    }
}