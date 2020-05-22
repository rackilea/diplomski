package com.tazligen.model;

@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupMemberMap {

    @JsonProperty("userId")
    private String userId;
    @JsonProperty("groupId")
    private String groupId;

    /* Add Constructor */
    public GroupMemberMap() {}

    /* Corrected Name */
    public String getUserId() {
        return userId;
    }

    /* Corrected Name */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }    
}