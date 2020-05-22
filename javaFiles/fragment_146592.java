import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        Response myPojo = mapper.readValue(jsonFile, Response.class);
        System.out.println(myPojo);
    }
}

class Response {

    private List<Value> values;

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Response{" +
                "values=" + values +
                '}';
    }
}

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
class Value {

    private long timestamp;
    private float val;

    @JsonCreator
    public Value(@JsonProperty("timestamp") long timestamp, @JsonProperty("val") float val) {
        this.timestamp = timestamp;
        this.val = val;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Value{" +
                "timestamp=" + timestamp +
                ", val=" + val +
                '}';
    }
}