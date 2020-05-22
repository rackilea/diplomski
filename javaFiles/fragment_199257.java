import com.fasterxml.jackson.annotation.JsonProperty;

public class Drivers {

    @JsonProperty("userID");
    private String userID = "";

    @JsonProperty("userMemID");
    private String userMemID = "";

    @JsonProperty("userFirstName");
    private String userFirstName = "";

    @JsonProperty("userLastName");
    private String userLastName = "";

    @JsonProperty("userSkillLevel");
    private String userSkillLevel = "";

    @JsonProperty("userProviderID");
    private String userProviderID = "";

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserMemID() {
        return userMemID;
    }

    public void setUserMemID(String userMemID) {
        this.userMemID = userMemID;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserSkillLevel() {
        return userSkillLevel;
    }

    public void setUserSkillLevel(String userSkillLevel) {
        this.userSkillLevel = userSkillLevel;
    }

    public String getUserProviderID() {
        return userProviderID;
    }

    public void setUserProviderID(String userProviderID) {
        this.userProviderID = userProviderID;
    }

}