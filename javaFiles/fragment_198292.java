public class ProductApi extends Product {

    @JsonProperty
    @Override
    public String getName() {
        return super.getName();
    };

    // ...

}