/**
 * Create an instance of {@link JAXBElement }{@code <}{@link NetType }{@code >}}
 * 
 */
@XmlElementDecl(namespace = "", name = "net")
public JAXBElement<NetType> createNet(NetType value) {
    return new JAXBElement<NetType>(_Net_QNAME, NetType.class, null, value);
}