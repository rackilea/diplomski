@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace="urn:XXXX_HPD_IncidentInterface_WS__XXXXX")
public class HelpDesk_Query_ServiceResponse {
    @XmlElement(namespace="urn:XXXX_HPD_IncidentInterface_WS__XXXXX")
    String Assigned_Group;
    @XmlElement(namespace="urn:XXXX_HPD_IncidentInterface_WS__XXXXX") 
    String Organization;
    @XmlElement(namespace="urn:XXXX_HPD_IncidentInterface_WS__XXXXX")
    String City;
//other attribute and their Getter and setter
}