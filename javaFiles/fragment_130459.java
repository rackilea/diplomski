import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main {

public static void main(String[] args) throws JSONException {
    String test = "[{\"hireDate\": null,\"homePhoneNumber\": null,\"gender\": null,\"city\": null,\"mobileNumber\": null,\"idNumber\": 123,\"religion\": null,\"leftOver\": 1,\"annualVacations\": 5,\"dob\": null,\"name\": null,\"rank\": 0,\"id\": 1,\"workingHours\": [],\"email\": \"ayman.daraghmah@exalt.ps\",\"managers\": [],\"alternativeMobileNumber\": null,\"activated\": true,\"username\": \"ayman.daraghmah@exalt.ps\"},{\"hireDate\": null,\"homePhoneNumber\": null,\"gender\": null,\"city\": null,\"mobileNumber\": null,\"idNumber\": 123,\"religion\": null,\"leftOver\": 1,\"annualVacations\": 5,\"dob\": null,\"name\": null,\"rank\": 0,\"id\": 11,\"workingHours\": [],\"email\": \"aymandaraghmah@gmail.com\",\"managers\": [],\"alternativeMobileNumber\": null,\"activated\": true,\"username\": \"aymandaraghmah@gmail.com\"}]";

    JSONArray jsonArray = new JSONArray(test);

    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject explrObject = jsonArray.getJSONObject(i);
        System.out.println(explrObject.getString("username"));

    }
  }
}