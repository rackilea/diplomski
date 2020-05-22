import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();

        ApiWrapper api = mapper.readValue(jsonFile, ApiWrapper.class);

        System.out.println(api);
    }
}

class ApiWrapper {

    private Api api;

    // getters, setters, toString
}

class Api {

    private int results;
    private Odds odds;

    // getters, setters, toString
}

class Odds {

    @JsonProperty("Win the match")
    private Map<String, Match> winTheMatch;

    // getters, setters, toString
}

class Match {

    private String label;
    private String pos;
    private String odd;

    // getters, setters, toString
}