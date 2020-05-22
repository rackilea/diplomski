public interface DueType /* Really a strategy now */ {
   void doSomeThing(Due d);
}

public interface CustomerType  /* Really a strategy now */ {
   void doSomething(Due d);
}

public final class Due {

  private String dueId;
  private BigDecimal dueAmount;
  private Date dueDate;
  DueType dueType;
  CustomerType customerType;    

  public Due(CustomerType type, DueType dueType) {
     this.customerType = type;
     this.dueType = dueType
  }
}

public class XDueType implements DueType {
...
}

public clasx XCustomerType implements CustomerType {
...
}