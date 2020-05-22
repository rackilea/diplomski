import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ResponseEntity entity = new ResponseEntity("dynList",
                Collections.singletonList(Collections.singletonMap("key", "value1")));

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println(mapper.writeValueAsString(entity));
    }
}

class ResponseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private int total_record_count;
    private int filtered_record_count;

    private String propertyName;

    @JsonIgnore
    private List<Map<String, Object>> entityList;

    public ResponseEntity(String propertyName, List<Map<String, Object>> entityList) {
        this.propertyName = propertyName;
        this.entityList = entityList;
        this.filtered_record_count = entityList.size();
    }

    @JsonAnyGetter
    public Map<String, Object> otherProperties() {
        return Collections.singletonMap(propertyName, entityList);
    }

    // other methods
}