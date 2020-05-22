import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonDeserializer {

    public static void main(String[] args) {
        try {
            // ObjectMapper provides functionality for data binding between
            ObjectMapper mapper = new ObjectMapper();

            String jsonString = "{\"submitDate\":\"2015-04-16\",\"submittedBy\":\"Gaurav Varma\",\"supplier\":\"Amazon\",\"orderName\":\"This is my order\"," 
                    + "\"price\": {\"value\": \"2000\",\"currency\": \"USD\"}"
                    + "}";
            System.out.println("JSON String: " + jsonString);

            // Deserialize JSON to java format and write to specific POJOs
            Submitter submitterObj = mapper.readValue(jsonString, Submitter.class);
            Order orderObj = mapper.readValue(jsonString, Order.class);
            Price priceObj = orderObj.getPrice();

            System.out.println("submitterObj: " + submitterObj);
            System.out.println("orderObj: " + orderObj);
            System.out.println("priceObj: " + priceObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}