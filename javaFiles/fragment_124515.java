void fireEvent( Event event ) {
  List<EventSubscriber<?>> subscribers = subscriberMap.get( event.getClass() );
  //This cast will cause warnings that you'll want to suppress 
  //via @SuppressWarnings ( { "rawtypes", "unchecked" } ) on the method level
  subscribers.forEach(s -> ((EventSubscriber)s).receiveEvent( event ) );
}