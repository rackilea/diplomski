@JacksonXmlRootElement(localName = "someObject")
public static class SomeObject {
    @JacksonXmlProperty(localName = "someArray")
    String[] someArray; 

    @Override
    public String toString() {
        return Arrays.asList(someArray).toString();
    }
}