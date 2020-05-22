@XmlRootElement(name = "PricingGroup")
public class PricingGroup {

    ...

    @XmlTransient    
    private List<BilltoCustomer> billtoCustomers = new ArrayList<BilltoCustomer>();

    @XmlAttribute(name = "partyName")
    @XmlJavaTypeAdapter(PartyNames.Adapter.class)
    private PartyName partyName;  


   void afterUnmarshal(Unmarshaller u, Object parent) {
      // Derive billToCustomers from partyName
   }

    ...  
}