import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonFoo
{
  public static void main(String[] args)
  {
    MyBean bean = new MyBean();
    bean.data = "some data";
    bean.problem = new RuntimeException("Ack!");

    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Exception.class, new ExceptionSerializer());
    Gson gson = gsonBuilder.create();

    System.out.println(gson.toJson(bean));
  }
}

class ExceptionSerializer implements JsonSerializer<Exception>
{
  @Override
  public JsonElement serialize(Exception src, Type typeOfSrc, JsonSerializationContext context)
  {
    JsonObject jsonObject = new JsonObject();
    jsonObject.add("cause", new JsonPrimitive(String.valueOf(src.getCause())));
    jsonObject.add("message", new JsonPrimitive(src.getMessage()));
    return jsonObject;
  }
}

class MyBean
{
  public String data;
  public Exception problem;
}