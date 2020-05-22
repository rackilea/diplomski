import java.io.File;
import java.util.List;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonFoo
{
  public static void main(String[] args) throws Exception
  {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

    RuleModel model = mapper.readValue(new File("input.json"), RuleModel.class);
    System.out.println(mapper.writeValueAsString(model));
  }
}