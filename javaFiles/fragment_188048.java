@XmlRootElement(name = "Say")
@XmlAccessorType(XmlAccessType.FIELD)
static class Say {

    @XmlAttribute
    private String voice = "alice";

    @XmlValue
    private String string = "Thanks for trying our documentation. Enjoy!";

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}