public enum SkillLevel {    
    DISASTROUS(1, "Disastrous"),
    POOR(2, "Poor"),
    WEAK(3, "Weak");    

    private final int intValue;
    private final String description;        

    private SkillLevel(int intValue, String description) {
        this.intValue = intValue;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getIntValue() {
        return intValue;
    }

    public static SkillLevel fromInt(int value) {
        for (SkillLevel level : values()) {
            if (level.getIntValue() == value) {
                return level;
            }
        }        
        throw new IllegalArgumentException("No such level");
    }
}