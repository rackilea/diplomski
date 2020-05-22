String singleIPRegex = "yourRegex";
String rangeRegex = singleIPRegex + "-" + singleIPRegex;

if (someString.matches(rangeRegex)){
    //do your stuff
}