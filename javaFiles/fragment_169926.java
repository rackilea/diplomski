@Entity
 public class Loan {

     @AttributeOverrides({
             @AttributeOverride(name = "denomination", 
                                column = @Column(name = "valuedenomination")),
             @AttributeOverride(name = "currencyCode", 
                                column = @Column(name = "valuecurrencycode")) })
     private Money value;

    @AttributeOverrides({
             @AttributeOverride(name = "denomination", 
                                column = @Column(name = "interestdenomination")),
             @AttributeOverride(name = "currencyCode", 
                                column = @Column(name = "interestcurrencycode")) })
     private Money interest;

 }