@XmlRootElement(name = "range")
public class RangeClass {

    private Higher higher;

    private Lower lower;
}

@XmlElement(name = "higher")
public class Higher {

    @XmlAttribute
    private int value;
}

@XmlElement(name = "lower")
public class Lower {

    @XmlAttribute
    private int value;
}