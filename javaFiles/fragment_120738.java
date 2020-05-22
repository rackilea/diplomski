@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="payloadResponse")
public class PayloadResponse extends AbstractResponse{
    @XmlElementWrapper(name="decodedPayloads")
    @XmlElementRefs({
        @XmlElementRef(type=GeoPayload.class),
        @XmlElementRef(type=GeoLocationDecodedPayload .class),
        @XmlElementRef(type=AltitudeDecodedPayload .class)