public class RegistrationModel {

  private RegistrationClient _client;

  public RegistrationModel() {
    RestAdapter restAdapter = new RestAdapter.Builder() ... // create an adapter
    _client = restAdapter.create(RegistrationClient.class);
  }

  public void connect(String country, String state, String email, String password) { 
    // you can add an additional callback parameter for returning info to the caller.
    _client.connect(country, state, email, password, new Callback<RegistrationResult> {

      @Override
      public void failure(RetrofitError error) {
        // Do the essential things, and do a callback to the caller if needed
      }

      @Override
      public void success(RegistrationResult result, Response response) {
        // Do the essential things, and do a callback to the caller if needed
      }
   }
}