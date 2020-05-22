import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
class TweetHit {
    private final Long sortValue;
    private final String uid;

    @JsonCreator
    public TweetHit(@JsonProperty("sort") String[] sort) {
        this.sortValue = Long.parseLong(sort[0]);
        this.uid = sort[1];
    }
}

public class StackOverflow {
    public static void main(String[] args) throws IOException {
        String json = "{ \"sort\": [\n" +
                "      1486549042000,\n" +
                "      \"tweet#AVodOsgk0etILSbJamY-\"\n" +
                "    ]\n" +
                "  }";

        ObjectMapper objectMapper = new ObjectMapper();
        TweetHit tweetHit = objectMapper.readValue(json, TweetHit.class);
    }
}