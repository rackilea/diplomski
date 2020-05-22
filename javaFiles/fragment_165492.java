import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJackson {
    public static void main(String[] args) {
        Person p3 = new Person("X", new ArrayList<Person>());
        Person p2 = new Person("Y", new ArrayList<Person>());
        Person p1 = new Person("Z", new ArrayList<Person>());
        p2.getChildren().add(p3);
        p1.getChildren().add(p2);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("person.json"), p1);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}