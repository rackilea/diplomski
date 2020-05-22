import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JsonAdapterExample {
  public static void main(String[] args) {
    Gson g = new Gson();

    System.out.println(g.toJson(new Car()));
  }

  public static class Car {
    @JsonAdapter(IdAdapter.class)
    Integer id = 10;
  }

  public static class IdAdapter extends TypeAdapter<Integer> {
    @Override
    public Integer read(JsonReader arg0) throws IOException {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public void write(JsonWriter arg0, Integer arg1) throws IOException {
      arg0.beginObject();
      arg0.name("id");
      arg0.value(String.valueOf(arg1));
      arg0.endObject();
    } 
  }
}