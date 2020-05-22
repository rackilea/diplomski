//model for using with mapper
public class DatabaseProfile {
    String name;
    String address;
}

//converts database profile to Profile
public class ProfileResultHandler implements ResultHandler {
  private List<AdStrategyTargetDTO> profiles = new ArrayList<>();

  public List<Profile> getProfiles() { return profiles; }

  @Override public void handleResult(ResultContext context) {
    DatabaseProfile databaseProfile = (DatabaseProfile)context.getResultObject();

    Address address = getAddress(databaseProfile.getAddress());
    Profile profile = new Profile(databaseProfile.getName(),address);

    profiles.add(profile);
  }

  private Address getAddress(String addressString){
      Address address = new Address();
      //do you string parsing here and fill in address object 
      //hopefully just using some deserializer but if all else fails 
      //this is where you would manually parse the string, I'll leave that 
      //detail up to you
      return address;
  }
}