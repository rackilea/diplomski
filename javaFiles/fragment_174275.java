import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisteredUserPeriod {
    private String period;
    @JsonProperty("Users Registered")
    private int usersRegistered;

    public RegisteredUserPeriod(String period, int usersRegistered) {
        this.period = period;
        this.usersRegistered = usersRegistered;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getUsersRegistered() {
        return usersRegistered;
    }

    public void setUsersRegistered(int usersRegistered) {
        this.usersRegistered = usersRegistered;
    }
}