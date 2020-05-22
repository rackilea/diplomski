@Getter
@Setter
public class MainResponse
{
    @JsonProperty("identifier_type")
    private String identifierType;

    @JsonProperty("simple_construct_response")
    private List<SimpleConstructResponse> simpleConstructResponseList;
}

@Getter
@Setter
public class SimpleConstructResponse
{
    private String identifier;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("trim_code")
    private String trimCode;

    @JsonProperty("trim_reason_code")
    private String trimReasonCode;

    @JsonProperty("simple_products")
    private List<SimpleProduct> simpleProducts;
}

@Getter
@Setter
public class SimpleProduct
{
    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_presentment_timestamp")
    private String productPresentmentTimestamp;
}