public class Pojo {
public String message;

public Pojo() {
}

@Override
public String toString() {
    return "Pojo [message=" + message + "]";
}

public Pojo(String message) {
    super();
    this.message = message;
}

public String getMessage() {
    return message;
}

public void setMessage(String message) {
    this.message = message;
}


public static void main(String[] args) {
    final ObjectMapper mapper = new ObjectMapper();

    //in your code the passed JsonNode is populated from the request
    ObjectNode node = mapper.createObjectNode();        
    node.put("message", "Hey friend");

    try {
        Pojo mPojo = mapper.treeToValue(node, Pojo.class);
        System.out.println("Message -> " + mPojo.getMessage());
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
}