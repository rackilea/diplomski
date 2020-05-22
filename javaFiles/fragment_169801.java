for (int i = 0; i < exampleString.length - 2; i++) {
//subtract 2 to prevent subString from throwing an error
    if ((exampleString.subString(i, i + 2).charAt(1) = " " && exampleString.subString(i, i + 2).charAt(2) != " ") || i = 0) {
//add 2 to get a space and a letter, then test the first character for a 
//space and the second character for NOT a space, also increment words if 
//i = 0, presuming there is no space at the beginning of the string
        words++;
    }
}