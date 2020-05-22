public enum SpecialCharacter {
    Hack("H/K"),
    Gk("G*M");

    private String value;

    private SpecialCharacter(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value; // This will return , # or +
    }

    public static SpecialCharacter valueOfKey(String key) {
        for (SpecialCharacter specialCharacter : values()) {
            if (specialCharacter.toString().equals(key)) {
                return specialCharacter;
            }
        }
        throw new IllegalArgumentException("Illegal key");
    }
}