@Getter
@Setter
public class User extends MyPojo {

    private String id;

    @NotBlank
    private String userName;

    private String companyId;
}