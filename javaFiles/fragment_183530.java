String original = "http://www.someHost.com/somePage?key1=value1&key2=value2";
Pattern keyValPattern = Pattern.compile("\\p{Alpha}\\w+=[^&]+");
Matcher m = keyValPattern.matcher(original);  
m.find(); // find an occurence of key=value pair
String keyVal = m.group(); // get the value of the found pair
// keyVal will be 'key1=value1'
int start = m.start(); // the start index of 'key1=value1' in the original string
int end = m.end(); //the end index of 'key1=value1' in the original string
m.find();
String keyVal2 = m.group();// keyVal2 will be 'key2=value2'
// ... etc