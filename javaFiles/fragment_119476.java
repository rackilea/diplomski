private char[] getInitials(String name) {
    char firstNameInitials = name.charAt(0);
    int indexOfSpace = name.indexOf(" ");
    char surnameInitials = name.charAt(indexOfSpace + 1);

    char[] result  = {firstNameInitials, surnameInitials};
    return result;
}