import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class MyDeserializer implements JsonDeserializer<Decode> {

@Override
public Decode deserialize(JsonElement arg0, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
    JsonObject decodeObj = arg0.getAsJsonObject();
    Gson gson = new Gson();
    Decode decode = gson.fromJson(arg0, Decode.class);
    List<String> values = null;
    if (decodeObj.get("value").isJsonArray()) {
        values = gson.fromJson(decodeObj.get("value"), new TypeToken<List<String>>() {
        }.getType());
    } else {
        String single = gson.fromJson(decodeObj.get("value"), String.class);
        values = new ArrayList<String>();
        values.add(single);
    }
    decode.setValues(values);
    return decode;
 }

}