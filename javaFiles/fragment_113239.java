class Joke {
    @JacksonXmlProperty(isAttribute = true)
    long id;

    @JacksonXmlProperty(localName = "title")
    String title;

    public String toString() {
        return new StringBuffer().append('[')
                .append(id).append(',')
                .append(title).append(']').toString();
    }
    // getters setters 
}