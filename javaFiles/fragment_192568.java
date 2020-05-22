import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@ToString
public class TelephoneNumber {
   @JsonProperty("number")
   private String number;
   @JsonProperty("native")
   private String nativeValue; //or however you want to name it
   @JsonProperty("preferred")
   private String preferred;
}