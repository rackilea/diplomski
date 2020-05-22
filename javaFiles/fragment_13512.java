@Data
@Builder
@AllArgsConstructor
public class UserInfo { 
    private int id;
    private String nick;
    @Builder.Default
    private boolean isEmailConfirmed = true;

    public UserInfo(){
        isEmailConfirmed = true;
    }
}