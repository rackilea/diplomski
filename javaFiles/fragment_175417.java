import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);

        System.out.println(mapper.readValue(jsonFile, People.class).getPersons());
    }
}

class People {

    private List<Details> persons = new ArrayList<>();

    @JsonAnySetter
    public void setPerson(String name, Details person) {
        this.persons.add(person);
    }

    public List<Details> getPersons() {
        return persons;
    }

    public static class Details {
        String name;
        String address;
        String email;

        // getters, setters, toString
    }
}