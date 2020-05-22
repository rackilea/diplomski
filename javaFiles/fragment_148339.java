import java.io.Serializable;
 import java.util.List;
 import org.webservice.business.serializer.LoanApplicationSerializer;
 import com.fasterxml.jackson.databind.annotation.JsonSerialize;


  @JsonSerialize(using=LoanApplicationSerializer.class)
  public class LoanApplication  implements Serializable {

/**
 * 
 */
private static final long serialVersionUID = 1L;
private double amount;
private User borrowerId;
private String businessType;
private String currency;
private int duration;
private Date lastChangeDate;
private long loanApplicationId;
private String myStory;
private String productCategory;
private String purpose;
private Date startDate;
private String status;
private String type;
private String salesRepresentative;