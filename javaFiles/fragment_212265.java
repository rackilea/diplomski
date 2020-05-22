import java.lang.reflect.Type;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class GsonTestClass {

    static class MyDeserializer implements JsonDeserializer<Check> {

        public Check deserialize(JsonElement arg0, Type arg1,
                JsonDeserializationContext arg2) throws JsonParseException {
            JsonObject jsonObject = arg0.getAsJsonObject().get("check").getAsJsonObject();
            // this code could be improved with null checks and so on...
            return new Check( //
                    jsonObject.get("domain").getAsString(), //
                    jsonObject.get("status").getAsString() //
            );
        }

    }

    public static void main(String args[]) {
        Gson gson = new GsonBuilder().registerTypeAdapter(Check.class, new MyDeserializer()).create();
        String json = "[{\"check\":{\"status\":\"2\",\"domain\":\"william.com.br\"}}]";
        Type fooType = new TypeToken<Collection<Check>>() {}.getType();
        System.out.println((gson.fromJson(json, fooType)));
    }

    static class Check {

        private String domain;
        private String status;

        public Check() {
        }

        public Check(String domain, String status) {
            super();
            this.domain = domain;
            this.status = status;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "Check: " + domain + " - " + status;
        }

    }

}