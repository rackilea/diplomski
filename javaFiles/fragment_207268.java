public void echoOnMembers( String input, Set<Member> members ) throws Exception {
  HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
  IExecutorService executorService = 
      hazelcastInstance.getExecutorService( "default" );

  Map<Member, Future<String>> futures = executorService
      .submitToMembers( new Echo( input ), members );

  for ( Future<String> future : futures.values() ) {
    String echoResult = future.get();
    // ...
  }
}