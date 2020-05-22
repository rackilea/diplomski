import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        Gson gson = new GsonBuilder().create();

        FlightResponse flightResponse = gson.fromJson(new FileReader(jsonFile), FlightResponse.class);

        flightResponse.getFlatData().forEach((k, v) -> {
            System.out.println(k + " => " + v);
        });
    }
}