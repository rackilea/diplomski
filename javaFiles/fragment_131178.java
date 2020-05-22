import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.IOException;

public class PasswordSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String s, JsonGenerator jg, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {

         // do your staff here.

    }
}