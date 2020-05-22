@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ParameterValue {

    @XmlAttribute(name="encoding") private String encoding;
    @XmlValue private String value;
  ..
}