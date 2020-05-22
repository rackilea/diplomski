boolean hasDigit = false;
String passCode = "abc";
for (int i = 0; i < passCode.length(); i++) {
    if(Character.isDigit(passCode.charAt(i))) {
        hasDigit = true;
        break;
    }
}