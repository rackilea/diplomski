public class ProductDeserializer extends StdDeserializer<Product> {

  public ProductDeserializer() {
      super(Product.class);
  }

  @Override
  public Product deserialize(JsonParser parser, DeserializationContext ctxt) throws IOException {
    Product p = new Product();

    while (parser.nextToken() != JsonToken.END_OBJECT) {
        String tokenName = parser.getCurrentName();

        switch (tokenName) {
            case "id":
                parser.nextToken();
                p.setId(parser.getText());
                break;

            // when you encounter an attribute called value or "" you take its value 
            case "value":
            case "":
                parser.nextToken();
                p.setValue(parser.getText().trim());
                break;

            default:
                break;
        }
    }
    return p;
  }
}