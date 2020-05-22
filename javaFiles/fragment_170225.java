private static String findSubstringIndexes(String inputString, String stringToFind){
    String indexes = "";
    int index = inputString.indexOf(stringToFind);
    while (index >= 0){
        indexes+= (indexes.equals("")) ? String.valueOf(index) : ", " + String.valueOf(index);
        index = inputString.indexOf(stringToFind, index + stringToFind.length())   ;
    }
    return indexes;
}