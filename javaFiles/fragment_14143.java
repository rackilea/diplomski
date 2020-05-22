public enum DueType { X, Y }
public enum CustomerType {X,Y}

public abstract class Due  {

  private String dueId;
  private BigDecimal dueAmount;
  private Date dueDate;

  public Due(CustomerType type) {
     this.customerType = type;
  }

  abstract DueType getDueType();
  abstract CustomerType getCustomerType();
}

public class XDue extends Due {

   @Override public DueType getDueType() {
     return DueType.X;
   }

   @Override public CustomerType getCustomerType() {
     return CustomerType.X;
   }
}