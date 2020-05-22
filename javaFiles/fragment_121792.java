@XmlRootElement
public class Reconcile {
    @XmlElement(name = "start_date")
    @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
    public LocalDateTime start_date;

    @XmlElement(name = "end_date")
    @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
    public LocalDateTime end_date;

    @XmlElement(name = "page")
    public int page;
}