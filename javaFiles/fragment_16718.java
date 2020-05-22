import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ListExtractor {
    public static void main(String[] args) {
        Client restClient = ClientBuilder.newClient();
        Response response = restClient.target("https://api.myjson.com/bins/7xq2x").request(MediaType.APPLICATION_JSON).get();
        List<Item> items = response.readEntity(new GenericType<List<Item>>() {});
        items.forEach(System.out::println);
    }

    static class Item {
        private String name;
        private String abbreviation;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAbbreviation() {
            return abbreviation;
        }

        public void setAbbreviation(String abbreviation) {
            this.abbreviation = abbreviation;
        }

        @Override
        public String toString() {
            return new StringBuilder().append("[name=").append(name).append(", abbreviation=").append(abbreviation).append("]")
                    .toString();
        }
    }
}