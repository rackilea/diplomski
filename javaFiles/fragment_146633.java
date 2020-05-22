boolean complies = false;
{
    boolean hasDigit     = false;
    boolean hasLowercase = false;
    boolean hasUppercase = false;
    for (int i = 0; i < password.length(); i++) {
        char c = password.charAt(i);
        hasDigit     |= '0' <= c && c <= '9';
        hasLowercase |= 'a' <= c && c <= 'z';
        hasUppercase |= 'A' <= c && c <= 'Z';
        if (hasDigit && hasLowercase && hasUppercase) {
            complies = true;
            break;
        }
    }
}