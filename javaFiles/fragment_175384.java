package jacksonTest;

import java.io.IOException;
import java.lang.reflect.Type;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class CustomDeserialiser {


public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    String json = "{\"42010\":{\"pageid\":42010,\"ns\":0,\"title\":\"Queen (band)\"}}";
    String json2 = "{\"12345\":{\"pageid\":12345,\"ns\":0,\"title\":\"Queen (band)\"}}";

    Gson g = new GsonBuilder().registerTypeAdapter(Pages.class, new PagesDeserialiser()).create(); 

    Pages fromJson = g.fromJson(json, Pages.class);
    System.out.println(fromJson);

    fromJson = g.fromJson(json2, Pages.class);
    System.out.println(fromJson);
}

public static class PagesDeserialiser implements JsonDeserializer<Pages> {

    @Override
    public Pages deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws com.google.gson.JsonParseException {
        JsonObject object = json.getAsJsonObject();

        Pages p = new Pages();
        object.entrySet().forEach( e -> {
            JsonObject tmp = e.getValue().getAsJsonObject();
            if(tmp.get("pageid") != null) {
                // right object
                p._42010 = new _42010();
                p._42010.ns = tmp.get("ns").getAsInt();
                p._42010.pageid = tmp.get("pageid").getAsInt();
                p._42010.title = tmp.get("title").getAsString();
            }
        });

        return p;
    }

}

public static class Pages {

    _42010 _42010;

    @Override
    public String toString() {
        return _42010.toString();
    }


}

public static class  _42010 {
    int pageid;
    int ns;
    String title;

    @Override
    public String toString() {
        return title + " " + pageid + " " + ns;
    }
}