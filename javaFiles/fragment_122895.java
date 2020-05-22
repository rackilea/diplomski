import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {

@XmlElementWrapper(name = "transaction_types")
public List<TransactionType> transactionType;

public Transaction() {
}
}