import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.mrbean.MrBeanModule;

public class AbstractPojosExample {

    public interface Person {

        String getName();

        int getAge();

        Address getAddress();

        default String asString() {
            return String.format("%s, %d, %s", this.getName(), this.getAge(), this.getAddress().asString());
        }
    }

    public interface Address {

        String getStreet();

        String getCity();

        default String asString() {
            return String.format("%s, %s", this.getStreet(), this.getCity());
        }
    }

    private void run() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new MrBeanModule());

        String json = "[ { \"name\": \"John\", \"age\": 23, "
            + "\"address\": { \"street\": \"1001 5th Ave\", \"city\": \"New York\" } }, "
            + "{ \"name\": \"Jean Jacques\", \"age\": 26 , "
            + "\"address\": { \"street\": \"1001 Champs Elysees Blvd\", \"city\": \"Paris\" } }, "
            + "{ \"name\": \"Oscar Ruben\", \"age\": 54, "
            + "\"address\": { \"street\": \"1001 9th July Ave\", \"city\": \"Buenos Aires\" } } ]";
        System.out.println(json);

        List<Person> people = mapper.readValue(json, new TypeReference<List<Person>>() {});

        people.stream().map(Person::asString).forEach(System.out::println);
    }

    public static void main(String[] args) throws IOException {
        AbstractPojosExample example = new AbstractPojosExample();
        example.run();
    }
}