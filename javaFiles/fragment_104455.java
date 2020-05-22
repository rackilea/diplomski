Pattern p = Pattern.compile("[0-9]+$"); // This regex matches the last number
Matcher m = p.matcher(str); // Create the matcher

//If the pattern matches then we get the matching string
if(m.find()) { 
    result = m.group();
}