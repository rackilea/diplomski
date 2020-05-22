//build the map
Map<Integer, Organization> orgsInDB = new HashMap<>();
for( Organization org : organizationList ) {
  orgsInDB.put(org.getId(), org );
}

//match
for( Organization org : organizations ) {
  Organization orgInDB = orgsInDB.get( org.getId() );
  if( orgInDB != null ) {
    orgInDB.setFollowed( true );
  }
}