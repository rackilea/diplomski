new RemovalListener<Key, ConnectionWrapper>() {
   public void onRemoval(RemovalNotification<Key, ConnectionWrapper> notification) {
     ConnectionWrapper wrapper = notification.getValue();
     if (wrapper.users == 0) {
       // do the teardown ourselves; nobody's using it
       wrapper.tearDown();
     } else {
       // it's still in use; mark it as expired from the cache
       wrapper.expiredFromCache = true;
     }
  }
}