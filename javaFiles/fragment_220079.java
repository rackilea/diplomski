import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class GsonApp {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        MyObj myObj = gson.fromJson(
                "{\"Id\": 703,\"StartDate\": \"2019-10-01T00:00:00\",\"EndDate\": \"2019-10-25T00:00:00\",\"Title\": \"exmample title\"}",
                MyObj.class);
        System.out.println(myObj);
    }
}

class IsoDateTimeJsonDeserializer implements JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        LocalDateTime localDateTime = LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_DATE_TIME);

        return Date.from(localDateTime.atZone(ZoneOffset.systemDefault()).toInstant());
    }
}

class MyObj {

    @SerializedName("Id")
    private Long id;

    @SerializedName("StartDate")
    @JsonAdapter(IsoDateTimeJsonDeserializer.class)
    private Date startDate;

    @SerializedName("EndDate")
    @JsonAdapter(IsoDateTimeJsonDeserializer.class)
    private Date endDate;

    @SerializedName("Title")
    private String title;

    // getters, setters, toString
}