import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JacksonFoo
{
  public static void main(String[] args) throws Exception
  {
    Map<String, Foo> foos = new HashMap<String, Foo>();
    foos.put("foo1", new Foo("foo1"));
    foos.put("foo2", new Foo(null));
    foos.put("foo3", null);
    foos.put(null, new Foo("foo4"));

    // System.out.println(new ObjectMapper().writeValueAsString(foos));
    // Exception: Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)

    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    mapper.setSerializationInclusion(Include.NON_NULL);
    mapper.getSerializerProvider().setNullKeySerializer(new MyNullKeySerializer());
    System.out.println(mapper.writeValueAsString(foos));
    // output: 
    // {"":{"bar":"foo4"},"foo2":{},"foo1":{"bar":"foo1"}}
  }
}

class MyNullKeySerializer extends JsonSerializer<Object>
{
  @Override
  public void serialize(Object nullKey, JsonGenerator jsonGenerator, SerializerProvider unused) 
      throws IOException, JsonProcessingException
  {
    jsonGenerator.writeFieldName("");
  }
}

class Foo
{
  public String bar;

  Foo(String bar)
  {
    this.bar = bar;
  }
}