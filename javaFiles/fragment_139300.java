@Data
public class StaffUpdateRequestDTO {

  @NotNull(message = "Validation failure")
  @Valid
  private UserDetailsDTO userDetails;

  @NotNull(message = "Validation failure")
  @NotEmpty(message = "Validation Failure")
  private String approvedBy;

}