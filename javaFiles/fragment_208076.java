@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "WsRequest")
public final class WsRequest{
    @XmlElement(required = true)
    private String requstData;
}


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {})
@XmlRootElement(name = "WsResponse")
public final class WsResponse {
    @XmlElement(required = true)
    private String responseData;
}