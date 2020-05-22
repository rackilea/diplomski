Pattern modelRegEx = Pattern.compile("[^-]{15,}[^-]");
Matcher m = modelRegEx.matcher(temp);
while(m.find()){// <-- add this
    String model = m.group(0);
    //do stuff with each match you will find
}