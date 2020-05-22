import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MainProgram {

    public static void main(String[] args) {
        String mineCraft = "{  \"objects\": {    \"minecraft/sounds/mob/stray/death2.ogg\": {      \"hash\": \"d48940aeab2d4068bd157e6810406c882503a813\",      \"size\": 18817    },    \"minecraft/sounds/mob/husk/step4.ogg\": {      \"hash\": \"70a1c99c314a134027988106a3b61b15389d5f2f\",      \"size\": 9398    }}}";
        JsonParser parser = new JsonParser();
        JsonObject objects = parser.parse(mineCraft).getAsJsonObject().get("objects").getAsJsonObject();

        for (Map.Entry<String, JsonElement> entry : objects.entrySet()) {
            String oggFileName = entry.getKey();
            JsonElement attributes = entry.getValue();
            System.out.println(
                    "Key is " + oggFileName + " and the hash value is " + attributes.getAsJsonObject().get("hash"));
        }
    }

}