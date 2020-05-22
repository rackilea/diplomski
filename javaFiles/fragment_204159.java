import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;

public class GsonApp {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        JsonArray array = new JsonArray();
        array.add(Math.PI);
        array.add(Math.E);

        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter) {
            @Override
            public JsonWriter value(Number value) throws IOException {
                BigDecimal bigDecimal = BigDecimal.valueOf(value.doubleValue());
                BigDecimal result = bigDecimal.setScale(3, BigDecimal.ROUND_UP);

                return super.value(result.doubleValue());
            }
        };
        jsonWriter.setIndent("  ");

        gson.toJson(array, jsonWriter);
        System.out.println(stringWriter.toString());
    }
}