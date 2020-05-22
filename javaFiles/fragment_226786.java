public class YourClass {

    private String aString;

    // Method that depends on third party component
    public void someMethod(ThirdPartyClass doc) {
        aString = doc.someStringValue();
    }

    public String getValue() {
        return aString;
    }
}