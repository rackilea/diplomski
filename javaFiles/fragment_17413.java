import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;


public class DeserializationErrorTest {

  @Test
  void testDeserializeWrongInput() throws IOException {
    final ObjectMapper mapper = new ObjectMapper();
    try {
      mapper.readValue("{\"foo\" : { \"bar\" : \"not-int\" }}", MyProxy.class);
    } catch (MismatchedInputException e) {
      throw remapMismatchedInputException(e, RuntimeException.class);
    }
  }

  private <T extends Exception> T remapMismatchedInputException(final MismatchedInputException e, Class<T> exClass) {
    try {
      final String fieldName =
          e.getPath().stream().map(JsonMappingException.Reference::getFieldName).collect(Collectors.joining("."));
      return exClass.getConstructor(String.class).newInstance(fieldName + " must be of type " + e.getTargetType().getSimpleName());
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException pE) {
      throw new IllegalArgumentException("Cannot instantiate exception class " + exClass.getSimpleName());
    }
  }

  static class MyProxy {
    @JsonProperty("foo") final FooProxy foo;

    @JsonCreator
    public MyProxy(@JsonProperty("foo") final FooProxy pFoo) {foo = pFoo;}
  }

  static class FooProxy {
    @JsonProperty("bar") final Integer bar;

    @JsonCreator
    public FooProxy(@JsonProperty("bar") final Integer pBar) {bar = pBar;}
  }
}