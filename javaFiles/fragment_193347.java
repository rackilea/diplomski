import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URL;
import java.util.stream.Stream;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        URL urlObject = new URL("https://osrsitemapi.azurewebsites.net/api/items");

        ObjectMapper mapper = new ObjectMapper();
        Item[] items = mapper.readValue(urlObject, Item[].class);

        System.out.println("Number of items: " + items.length);
        System.out.println("Show 10 items:");
        Stream.of(items).limit(10).forEach(System.out::println);
    }
}