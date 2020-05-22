val mapRolesBucket = new JSSourceFunction("""
      function(value){
            var splitarr=value.key.split('-'); 
            return [[ 'users', splitarr[1] ]];
          }
    """)
val mapUsersBucket = new JSSourceFunction("""
      function(value){
            var obj = Riak.mapValuesJson(value)[0];
            return [ obj ];
          }
    """)
    DB.client.mapReduce("rolesOfClientAdmins")
    .addKeyFilter(new TokenizeFilter("-", 1))
    .addKeyFilter(new MatchFilter(clientId))
    .addMapPhase(mapRolesBucket)
    .addMapPhase(mapUsersBucket)
    .execute().getResult(classOf[String])