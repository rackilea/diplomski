public static boolean isValid(String str){
    if (str.length() >= MIN_PASSWORD_LENGTH){
        // Removed call to .isValid(String)
        if (PasswordVerifier.hasUpperCase(str)){
            if (PasswordVerifier.hasLowerCase(str)){
                if (PasswordVerifier.hasDigit(str)){
                    return true;
                }
            }
        }
    }
    return false;
}