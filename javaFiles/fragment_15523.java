public class Test {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String json = "{\"type\":\"text\", \"message\": \"Hello\"}";

        // create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        MainObj mo = objectMapper.readValue(json, MainObj.class);

        System.out.println("type: " + mo.getType());

        MyClass instance = null;
        if (mo.getType().equalsIgnoreCase("text")) {
            // Do it for the 'text'
        } else {
            // Do it for the 'date'

        }
    }

}

class MainObj {
    private String type = "";
    private Object message = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}

class MyClass {
    public MyClass() {
    }
}