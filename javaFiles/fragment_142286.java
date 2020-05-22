@JacksonXmlRootElement(localName = "someObject")
public static class SomeObject {
    @JacksonXmlProperty(localName = "someArray")
    List<String> someArray; 

    @Override
    // for testing
    public String toString() {
        return someArray.toString();
    }
}

public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
    ObjectMapper map = new XmlMapper();
    String xmlStr = "<someObject><someArray><element>111</element><element>222</element></someArray></someObject>";
    SomeObject resultObj = map.readValue(xmlStr, new TypeReference<SomeObject>(){});
    System.out.println(resultObj);      
}