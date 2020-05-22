import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;

public class MyPropertyNamingStrategyTest {
    public static void main(String[] args) {
        PrivatePerson privatePerson = new PrivatePerson();
        privatePerson.setFirstName("John");
        privatePerson.setLastName("Smith");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(new MyPropertyNamingStrategy());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        StringWriter sw = new StringWriter();
        try {
            mapper.writeValue(sw, privatePerson);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sw.toString());
    }
}