import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

public class JacksonFoo
{
  public static void main(String[] args) throws Exception
  {
    // {"property1":{"property2":42}}
    String json1 = "{\"property1\":{\"property2\":42}}";

    // {"property1":[]}
    String json2 = "{\"property1\":[]}";

    SimpleModule module = new SimpleModule("", Version.unknownVersion());
    module.addDeserializer(Thing2.class, new ArrayAsNullDeserializer());

    ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, Visibility.ANY).withModule(module);

    Thing1 firstThing = mapper.readValue(json1, Thing1.class);
    System.out.println(firstThing);
    // output:
    // Thing1: property1=Thing2: property2=42

    Thing1 secondThing = mapper.readValue(json2, Thing1.class);
    System.out.println(secondThing);
    // output: 
    // Thing1: property1=null
  }
}

class Thing1
{
  Thing2 property1;

  @Override
  public String toString()
  {
    return String.format("Thing1: property1=%s", property1);
  }
}

class Thing2
{
  int property2;

  @Override
  public String toString()
  {
    return String.format("Thing2: property2=%d", property2);
  }
}

class ArrayAsNullDeserializer extends JsonDeserializer<Thing2>
{
  @Override
  public Thing2 deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException
  {
    JsonNode node = jp.readValueAsTree();
    if (node.isObject())
      return new ObjectMapper().setVisibility(JsonMethod.FIELD, Visibility.ANY).readValue(node, Thing2.class);
    return null;
  }
}