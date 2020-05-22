import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Base64InteriorToDtoConverter implements Converter<String, InteriorDTO> {

    @Override
    public InteriorDTO convert(String source) {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] valueDecoded = Base64.decodeBase64(source);
        InteriorDTO interiorDTO = null;
        try {
            interiorDTO = objectMapper.readValue(new String(valueDecoded), InteriorDTO.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return interiorDTO;
    }
}