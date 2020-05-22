public boolean isValidPassword(String password) {
    boolean containsLowerCase;
    boolean containsUpperCase;
    boolean containsInvalid;
    boolean containsSpecialChar;
    boolean containsDigit;

    for(char c: password.toCharArray()) {
        containsLowerCase   ||= Character.isLowerCase(c);
        containsUpperCase   ||= Character.isUpperCase(c);
        containsDigit       ||= Character.isDigit(c); 
        containsSpecialChar ||= someMethodForDetectingIfItIsSpecial(c);

    }

    return  containsLowerCase &&
            containsUpperCase &&
            containsSpecialChar &&
            containsDigit &&
            !containsInvalid &&
            password.length >=8 && password.length <=20;

}