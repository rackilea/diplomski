import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import java.io.IOException;
import java.io.StringWriter;

@Data
@NoArgsConstructor
public class PayloadResponse {
    private String house;

    @JsonProperty("has-large-house")
    private boolean largeHouse;

    @XmlElement(name = "completed-houses")
    private String completedHouses;

    public static void main(String[] args) throws IOException {
        ObjectMapper xmlMapper = new XmlMapper();
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        xmlMapper.registerModule(module);

        PayloadResponse response = new PayloadResponse();
        response.setHouse("The White House");
        response.setLargeHouse(true);
        response.setCompletedHouses("1600 Pennsylvania Ave.");

        StringWriter stringWriter = new StringWriter();

        // Serialize value as XML.
        xmlMapper.writeValue(stringWriter, response);
        System.out.println("XML=" + stringWriter);

        // Serialize value as JSON.
        ObjectMapper jsonMapper = new ObjectMapper();
        stringWriter.getBuffer().setLength(0);
        jsonMapper.writeValue(stringWriter, response);
        System.out.println("JSON=" + stringWriter);
    }
}