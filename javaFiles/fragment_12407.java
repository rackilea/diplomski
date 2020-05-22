@XmlRootElement
 @XmlAccessorType(XmlAccessType.FIELD)
 public class Transactions {

     @XmlElement(name="transaction")
     private List<Transaction> transactions;

 }