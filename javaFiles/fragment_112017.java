public class Person {

    @Parsed
    private String name;

    @Parsed
    private String position;

    @Nested
    private AddressInfo info;

}