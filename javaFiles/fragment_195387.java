@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse extends MyPojo {

    int responseCode;
    String responseMessage;
    List<Product> output;
}