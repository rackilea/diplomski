import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlAttribute;
 import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TransactionType {
@XmlElement(name = "transaction_type")
private String transaction_type;
@XmlAttribute
private String name;

public TransactionType(String transaction_type, String name) {
    this.transaction_type = transaction_type;
    this.name = name;
}

public TransactionType() {
}

public String getTransaction_type() {
    return transaction_type;
}

public void setTransaction_type(String transaction_type) {
    this.transaction_type = transaction_type;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return "TransactionTypes [transaction_type=" + transaction_type + ", name=" + name + "]";
}

}