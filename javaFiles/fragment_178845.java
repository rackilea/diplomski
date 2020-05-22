Pattern p = Pattern.compile("yourRegex");
Matcher m = p.matcher(yourData);
while(m.find()){//this will iterate over your data and in each iteration handle single match
    //if you want to know about indexes of current match you can use m.start or m.start(groupID)
    String textFound = m.group();
    int position = m.start();
    //now you can handle data you found, 
    //like place them in some map which will remember match and its first position
}