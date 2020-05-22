public List<Profile> getProfilesFromDatabase(){
   //the result handle just becomes a parameter of the interfaced call
   ProfileResultHandler resultHandler = new ProfileResultHandler
   profileMapper.getProfiles(resultHandler);

   return resultHandler.getProfiles();
}