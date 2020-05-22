public class WebObjectResponse {
     private Map<String, DataInfo> networks;
} 

public class DataInfo {
     private String id = null;
     private String name = null;
}

// later
Gson gson = new Gson();
String json = "{\"networks\": {\"tech11\": { \"id\": \"1\",\"name\": \"IDEN\" },  \"tech12\": { \"id\": \"2\", \"name\": \"EVDO_B\" }    }}";

WebObjectResponse response = gson.fromJson(json, WebObjectResponse .class);