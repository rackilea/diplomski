package stack.filter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "\"tblChecks\"")
public class Check implements Serializable
{

    private static final long serialVersionUID = 1L;

    /* Integereger values */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="checkId_seq")
    @SequenceGenerator(name="checkId_seq", sequenceName="checkId_seq", allocationSize=1)
    @Column(name = "\"checkId\"")
    private Integer checkId;

    @Column(name = "amount")
    private Double amount;

    /* String values */
    @Column(name = "\"bankId\"")
    private String bankId;

    @Column(name = "\"checkNumber\"")
    private String checkNumber;

    public Integer getCheckId()
        {
            return checkId;
        }

    public void setCheckId(Integer checkId)
        {
            this.checkId = checkId;
        }

    public Double getAmount()
        {
            return amount;
        }

    public void setAmount(Double amount)
        {
            this.amount = amount;
        }

    public String getBankId()
        {
            return bankId;
        }

    public void setBankId(String bankId)
        {
            this.bankId = bankId;
        }

    public String getCheckNumber()
        {
            return checkNumber;
        }

    public void setCheckNumber(String checkNumber)
        {
            this.checkNumber = checkNumber;
        }
}