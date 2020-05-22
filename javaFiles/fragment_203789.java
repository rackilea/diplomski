public class Email implements EntityMarker{ 
  @NotEmpty
  @org.hibernate.validator.constraints.Email
  private String emailId;
  ..//do whatever you want
}