int intWithZeros = 1020300; // for example
String intAsString = String.valueOf(intWithZeros); // represent the int as a String
String resultString= "";
for (char digit : intAsString.toCharArray()) { // cycle through every char 
    if(digit!='0') { // if it is not a zero
     resultString+=digit; // append it to the resultString
    }
}
if (!resultString.equals("")) {
    return Integer.parseInt(resultString);
}
return 0;