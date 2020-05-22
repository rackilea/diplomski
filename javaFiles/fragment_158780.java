import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JsonPathApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(Exception.class, ExceptionMixIn.class);
        mapper.addMixIn(Throwable.class, ThrowableMixIn.class);

        ExWrapper exW = mapper.readValue(jsonFile, ExWrapper.class);
        exW.ex.printStackTrace();
    }
}

@JsonIgnoreProperties("stackTrace")
abstract class ExceptionMixIn extends Exception {

    @JsonCreator
    public ExceptionMixIn(@JsonProperty("message") String message) {
        super(message);
    }
}

@JsonIgnoreProperties("stackTrace")
abstract class ThrowableMixIn extends Throwable {

    @JsonCreator
    public ThrowableMixIn(@JsonProperty("message") String message) {
        super(message);
    }
}

class ExWrapper {

    public Exception ex;

    @Override
    public String toString() {
        return "ExWrapper{" +
                "ex=" + ex +
                '}';
    }
}