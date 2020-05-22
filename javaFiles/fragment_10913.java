Map<Class<?>, Handler> handlers = ...;
Test1Handler test1Handler = new Test1Handler();
handlers.put( test1Handler.getHandledClass(), test1Handler );
//and others

for( Map.Entry<Class, Object> entry : objects.entrySet()){
  Handler h = handlers.get( entry.getKey() ); //ofc you need to "handle" unknown types etc. ;)
  h.handle( entry.getValue() );
}