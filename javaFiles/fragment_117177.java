boolean trueCheck = true;
int i;
char charCheck;

if (str != null && str.length() == 9) {

    for (i = 0; i < 9; i++) {

        // get the current character
        charCheck = str.charAt(i);

        // if the character is a letter or 0
        // the check is false, so set the flag and stop checking
        if (Character.isLetter(charCheck) || charCheck == '0') {
            trueCheck = false;
            break;
        }
    }   
}