import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionList {
@XmlElement(name = "transaction_type")
public List<TransactionType> transactionType;

public TransactionList(List<TransactionType> transactionTypes) {
    transactionType = transactionTypes;
}

public TransactionList() {
    super();
}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (TransactionType transactionType : transactionType) {
        sb.append(transactionType + "\n");
    }
    return sb.toString();
}
}