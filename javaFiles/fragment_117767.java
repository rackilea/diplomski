public class Response {
  public UserInfo[][] result;
}
public class UserInfo {
  public String usUserName;
  public boolean usActive;
}

ObjectMapper mapper = new ObjectMapper(); // must reuse for good performance
Response resp = mapper.readValue(jsonInput, Response.class);
// and use 'resp' however you want, now has the expected data.