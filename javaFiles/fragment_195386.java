@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse extends MyPojo {

    int responseCode;
    String responseMessage;
    List<User> output;
}