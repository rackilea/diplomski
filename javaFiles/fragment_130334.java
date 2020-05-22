@XmlRootElement
public class Test {
    @XmlElement
    @XmlJavaTypeAdapter(PointAdapter.class)
    public Point p;
}