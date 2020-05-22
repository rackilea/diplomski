import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class IntegerArrayList extends ArrayList<Integer> {
    String customField = "test";

    public IntegerArrayList(Integer... items) {
        super();
        addAll(Arrays.asList(items));
    }

    public static IntegerArrayList fromJson(String json) {
        IntegerArrayList integerArrayList = new GsonBuilder()
                .registerTypeAdapter(IntegerArrayList.class, new JsonAdapter())
                .enableComplexMapKeySerialization()
                .create()
                .fromJson(json, IntegerArrayList.class);
        return integerArrayList;
    }

    public String toJson() {
        return new GsonBuilder()
                .registerTypeAdapter(IntegerArrayList.class, new JsonAdapter())
                .enableComplexMapKeySerialization()
                .setPrettyPrinting()
                .create()
                .toJson(this, IntegerArrayList.class);
    }

    public static class JsonAdapter extends TypeAdapter<IntegerArrayList> {
        @Override
        public void write(JsonWriter out, IntegerArrayList value) throws IOException {
            out.beginObject();
            out.name("customField").value(value.customField);
            out.name("items");
            out.beginArray();
            for (Integer v : value) {
                out.value(v);
            }
            out.endArray();
            out.endObject();
        }

        @Override
        public IntegerArrayList read(JsonReader in) throws IOException {
            IntegerArrayList rtn = new IntegerArrayList();
            in.beginObject();
            while (in.hasNext()) {
                switch (in.nextName()) {
                    case "customField":
                        rtn.customField = in.nextString();
                        break;
                    case "items":
                        in.beginArray();
                        while (in.hasNext()) {
                            rtn.add(in.nextInt());
                        }
                        in.endArray();
                }
            }
            in.endObject();
            return rtn;
        }
    }
}

public class GsonTest {
    public static void main(String[] args) {
        IntegerArrayList integerArrayList = new IntegerArrayList(1, 2, 3, 4, 5);
        String json = integerArrayList.toJson();
        IntegerArrayList integerArrayList1 = IntegerArrayList.fromJson(json);
    }
}