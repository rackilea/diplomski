@ValidSecondary // Add this
public class UserDTO {
    @Valid
    private PrimaryDTO primaryDTO;
    private SecondaryDTO secondaryDTO; // No more @Valid
    private boolean primary;
}