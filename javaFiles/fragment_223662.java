import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Product {

    String file;
    boolean valid;
    String size;
    String charset;



    @JsonProperty("parameters")
    private void unpackNested(Map<String,Object> parameters) {
        this.size = (String)parameters.get("size");
        this.charset = (String)parameters.get("charset");
    }

}