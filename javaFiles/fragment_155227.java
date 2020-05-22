public class GroupPattern {
    private String group;
    private String pattern;
    public GroupPattern(String group, String pattern) {
        this.group   = group;
        this.pattern = pattern;
    }
    public String getGroup() {
        return group;
    }
    public String getPattern() {
        return pattern;
    }
    // Optionally setters, if it makes sense.
    public void setGroup(String group) {
        this.group = group;
    }
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }
}