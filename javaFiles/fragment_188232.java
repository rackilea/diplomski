import com.google.gson.Gson;
class YourErrorsJSON{
  private String domain 
  private String location;
  private String locationType; 
  private String message; 
  private String reason 
}

class YourJSON {
  private int code; 
  private YourErrorsJSON[] errors; 
  private String message;
}
Gson gson = new Gson();
YourJSON obj = gson.fromJson(json, YourJSON.class);