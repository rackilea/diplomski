import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

public class TransactionAdd {

    private String txnDate;
    private String refNumber;
    private String txnType;
    private List<LineAdd> lines;

    @XmlElement(name="TxnDate")
    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    @XmlElement(name="RefNumber")
    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    @XmlTransient
    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public List<LineAdd> getLines() {
        return lines;
    }

    public void setLines(List<LineAdd> lines) {
        this.lines = lines;
    }

}