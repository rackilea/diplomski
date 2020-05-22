public String uncommonCharacters(String str, String str2){
    String shorterString;
    String longerString;

    if (str.length() < str2.length()){
        shorterString = str;
        longerString = str2;
    } else {
        shorterString = str2;
        longerString = str;
    }

    StringBuilder charsNotInLongString = new StringBuilder();
    for(String charToRemove : shorterString.split("")) {
        String newLongerString = longerString.replaceFirst(charToRemove, "");
        if (newLongerString.equals(longerString)) {
            charsNotInLongString.append(charToRemove);
        } else {
            longerString = newLongerString;
        }
    }

    return longerString + charsNotInLongString.toString();
}