public static enum Validation {
    UPPER, LOWER, DIGIT //etc.
}

public static boolean isPasswordValid(String pwd, EnumSet<Validation> validations) {
//...
}