@XmlRootElement(name = "wrapper")
    public static class CCPWrapper {
        @XmlAnyElement
        List<String> keys = new ArrayList<>();
        @XmlAnyElement
        List<String> values = new ArrayList<>();
    }