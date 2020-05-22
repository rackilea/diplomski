import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Response {
    @JsonProperty("docs")
    public List<Doc> docs = new ArrayList<Doc>();
}