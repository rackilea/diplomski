public class UserDto {

    private String name;
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    private String surName;
    public String getSurName() { return surName; }
    public void setSurName(String surName) { this.surName = surName; }

    private Integer userCode;
    public Integer getUserCode() { return userCode; }
    public void setUserCode(Integer userCode) { this.userCode = userCode; }

    private String rule;
    public String getRule() { return rule; }
    public void setRule(String rule) { this.rule = rule; }

    public UserDto() {}

    public UserDto(String name, String surName, Integer userCode, String rule) {
        this.name = name;
        this.surName = surName;
        this.userCode = userCode;
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "UserDto{" +
            "name='" + name + '\'' +
            ", surName='" + surName + '\'' +
            ", userCode=" + userCode +
            ", rule='" + rule + '\'' +
            '}';
    }

}