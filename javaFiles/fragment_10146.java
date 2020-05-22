import com.github.filosganga.geogson.gson.GeometryAdapterFactory;
import com.github.filosganga.geogson.model.FeatureCollection;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake");
        URLConnection yc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new GeometryAdapterFactory())
                .create();

        FeatureCollection collection = gson.fromJson(in, FeatureCollection.class);
        collection.features().forEach(f -> {
            System.out.println(f.properties());
        });
    }
}