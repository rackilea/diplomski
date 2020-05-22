import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Transaction {

@XmlElement(name = "transaction_types")
public TransactionList transactionList;

public Transaction() {
    super();
}

@Override
public String toString() {
    return "Transaction [TransactionList=" + transactionList + "]";
 }
}