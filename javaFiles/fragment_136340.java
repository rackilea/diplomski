import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;
import javax.persistence.Converter;
import org.postgresql.util.PGobject;

@Converter(autoApply = true)
public class JsonConverter implements javax.persistence.AttributeConverter<JsonObject, Object> {

  private static final long serialVersionUID = 1L;
  private static ObjectMapper mapper = new ObjectMapper();

  @Override
  public Object convertToDatabaseColumn(JsonObject objectValue) {
    try {
      PGobject out = new PGobject();
      out.setType("json");
      out.setValue(objectValue.toString());
      return out;
    } catch (Exception e) {
      throw new IllegalArgumentException("Unable to serialize to json field ", e);
    }
  }

  @Override
  public JsonObject convertToEntityAttribute(Object dataValue) {
    try {
      if (dataValue instanceof PGobject && ((PGobject) dataValue).getType().equals("json")) {
        return mapper.reader(new TypeReference<JsonObject>() {
        }).readValue(((PGobject) dataValue).getValue());
      }
      return Json.createObjectBuilder().build();
    } catch (IOException e) {
      throw new IllegalArgumentException("Unable to deserialize to json field ", e);
    }
  }
}