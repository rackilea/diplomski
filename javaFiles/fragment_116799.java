@JacksonXmlRootElement(localName = "Root")
class Root {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Wrapper> keyValueList;
    // getters, setters
}