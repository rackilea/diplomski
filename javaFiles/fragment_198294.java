public class ProductApi extends Product {

    @JsonProperty
    @Override
    public String getName() {
        return super.getName();
    };

    // ...

    @JsonSerialize(using=ImagesSerializer.class)
    @JsonProperty("images")
    @Override
    public String getImage() { // in my entity this returns an image number, whereas in my JSON I want a list of URLs
        return "";
    }

    // ...

}