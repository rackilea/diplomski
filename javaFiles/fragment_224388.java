public class Response {
    private int id;
    private String name;
    //Getters and Setters
}

//code to convert
String response = sb.toString();
ObjectMapper mapper = new ObjectMapper();
Response responseObject = mapper.readValue(response, Response.class);