import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(IvrMapper.class, IvrMapperMixIn.class);

        System.out.println("Parse IvrRequest model: ");
        IvrRequest ivrRequest = mapper.readValue(jsonFile, IvrRequest.class);
        System.out.println(ivrRequest);

        System.out.println("Parse IvrMapper model: ");
        System.out.println(mapper.readValue(jsonFile, IvrMapper.class));

        System.out.println("Convert IvrRequest to IvrMapper");
        System.out.println(mapper.convertValue(ivrRequest, IvrMapper.class));
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
interface IvrMapperMixIn {

    @JsonProperty("age")
    int getId();

    @JsonProperty("children")
    List<IvrMapper> getResourceElements();
}

class IvrRequest {

    private int age;
    private String name;
    private String address;
    private List<IvrRequest> children;

    // getters, setters, toString
}

class IvrMapper {
    private int id;
    private String name;
    private List<IvrMapper> resourceElements;

    // getters, setters, toString
}