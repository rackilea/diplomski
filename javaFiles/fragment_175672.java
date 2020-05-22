@JacksonXmlRootElement(localName = "litre")
public @Data class Litre {

    @JacksonXmlProperty(localName = "krt")
    private Krt krt;

    public static @Data class Krt {

        @JacksonXmlProperty(localName = "geskrt")
        private Geskrt geskrt;
    }

    public static @Data class Geskrt {

        @JacksonXmlProperty(localName = "pkrt")
        @JacksonXmlElementWrapper(useWrapping = false)
        private List<Pkrt> pkrt;
    }

    public static @Data class Pkrt {

        @JacksonXmlProperty(isAttribute = true, localName = "data1")
        private double dataOne;

        @JacksonXmlProperty(isAttribute = true, localName = "data2")
        private double dataTwo;

        @JacksonXmlProperty(localName = "ints")
        private double inters;

        private String time;

        @JacksonXmlProperty(namespace = "xtpx:hor")
        private long hours;
    }
}