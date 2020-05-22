import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class MixIn {
    @JsonProperty("PNRNumber")
    abstract String getPNRNumber();

    @JsonProperty("XId")
    abstract int getXId();

    @JsonProperty("minPriced")
    abstract ArrayList getMinPriced();
}