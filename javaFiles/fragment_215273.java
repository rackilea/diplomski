public interface ProductTypeCreator {

    boolean isApplicable(String val1, String val2, String val3);

    ProductType create(String val1, String val2, String val3);

}