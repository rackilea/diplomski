import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) {
        String jsonStr = "{\"bills\":[{\"amount\":\"13\",\"billId\":\"billid3\"} ,{\"amount\":\"155\",\"billId\":\"billid4\"}]}";

        ObjectMapper mapper = new ObjectMapper();
        try {
            TestObject testObject = mapper.readValue(jsonStr, TestObject.class);
            System.out.print(testObject);
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}