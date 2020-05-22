public class IpAdressXmlHandler {

@XmlElement(name="ipAdress")
private String ipAdress;

public String getIpAdress() {
    return ipAdress;
}


public void setIpAdress(String ipAdress) {
    this.ipAdress = ipAdress;
}

@XmlRootElement(name="ipAdressXmlHandler")
public class IpAdressListXmlHandler {

@XmlElement(name="ipAdress")
private List<IpAdressXmlHandler> ipAdress;


public List<IpAdressXmlHandler> getIpAdressList() {
    return ipAdress;
}


public void setIpAdressList(List<IpAdressXmlHandler> ipAdress) {
    this.ipAdress = ipAdress;
}