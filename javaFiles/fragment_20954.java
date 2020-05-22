import java.io.FileInputStream;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class TestClass {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("yourpath/transactions.json")) {
            JsonFactory jf = new JsonFactory();
            JsonParser jp = jf.createParser(fis);
            //System.out.println(JsonToken.START_ARRAY);
            // jp.setCodec(new ObjectMapper());
            jp.nextToken();
            while (jp.hasCurrentToken()) {

                if (jp.getCurrentToken().equals(JsonToken.START_OBJECT)
                        || jp.getCurrentToken().equals(JsonToken.START_ARRAY)
                        || jp.getCurrentToken().equals(JsonToken.END_ARRAY)
                        || jp.getCurrentToken().equals(JsonToken.END_OBJECT)) {
                } else {
                    System.out.print(jp.getText());
                    jp.nextToken();
                    System.out.print(":");
                    System.out.print(jp.getText());
                    System.out.println();
                }
                jp.nextToken();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}