import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws Exception {
        new Main().start();
    }

    public List<Advert> adverts;

    private void start() throws Exception {

        String jsonString =
                "[" +
                    "{" +
                        "\"_id\": \"535788abf789b8916a8b456e\"," +
                        "\"adgroup_id\": \"535788abf789b8916a8b456c\"," +
                        "\"subcampaign_id\": \"535788abf789b8916a8b4569\"," +
                        "\"id\": 6005879321807," +
                    "}," +
                    "{" +
                        "\"_id\": \"535788abf789b8916a8b456f\"," +
                        "\"adgroup_id\": \"535788abf789b8916a8b456c\"," +
                        "\"subcampaign_id\": \"535788abf789b8916a8b4569\"," +
                        "\"id\": 6005879319007," +
                    "}" +
                "]";

        ObjectMapper mapper = new ObjectMapper();

        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            Advert advert = mapper.readValue(jsonObject.toString(), Advert.class);

            System.out.println("advertId: " + advert.advertId);
            System.out.println("adgroupId: " + advert.adgroupId);
        }

    }

}