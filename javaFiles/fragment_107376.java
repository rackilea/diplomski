public class UserDetails {
    private Long userId;
    private String login;
    private String firstName;
    private String lastName;
    private List<ActionDetailWrapper> confirmedActions;
}

public class ActionDetails {
    private Long actionId;
    private String actionName;
    private String actionDescription;
}

public class ActionDetailWrapper {
    private ActionDetails actionDetails;
    private Boolean result;
}